package com.bsfy.quickmodel

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import com.bsfy.superpluginmodel.dynamicload.internal.DLPluginManager
import com.bsfy.superpluginmodel.utils.DLUtils
import java.io.File


class ShellActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shell)

        PermissionsUtils.verifyStoragePermissions(this, {
            initData()
        })
    }

    private fun initData() {
        val pluginFolder = Environment.getExternalStorageDirectory().toString() + "/DynamicLoadHost"
        val file = File(pluginFolder)
        val plugins = file.listFiles()

        if (plugins != null) {
            for (plugin in plugins) {
                val item = PluginItem()
                item.pluginPath = plugin.absolutePath
                item.packageInfo = DLUtils.getPackageInfo(this, item.pluginPath)
                DLPluginManager.getInstance(this).loadApk(item.pluginPath)
            }
        }

    }


}
