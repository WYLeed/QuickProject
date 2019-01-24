package com.bsfy.quickmodel

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bsfy.quickmodel.ui.adapter.PluginsAdapter
import com.bsfy.superpluginmodel.dynamicload.internal.DLPluginManager
import com.bsfy.superpluginmodel.utils.DLUtils
import kotlinx.android.synthetic.main.activity_shell.*
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

        val list: MutableList<PluginItem> = ArrayList()

        if (plugins != null) {
            for (plugin in plugins) {
                val item = PluginItem()
                item.pluginPath = plugin.absolutePath
                item.packageInfo = DLUtils.getPackageInfo(this, item.pluginPath)
                list.add(item)
                DLPluginManager.getInstance(this).loadApk(item.pluginPath)
            }
        }

        val pluginsAdapter = PluginsAdapter(list, R.layout.adapter_plugins)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = pluginsAdapter

    }


}
