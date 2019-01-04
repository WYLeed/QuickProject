package com.bsfy.superweightmodel.feature.process

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bsfy.superutilsmodel.util.ProcessUtils
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity

/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/10/13
 * desc  : demo about ProcessUtils
</pre> *
 */
class ProcessActivity : BaseBackActivity() {

    private var tvAboutProcess: TextView? = null

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_process
    }

    @SuppressLint("MissingPermission")
    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_process)

        findViewById<View>(R.id.btn_kill_all_background_processes).setOnClickListener(this)
        tvAboutProcess = findViewById(R.id.tv_about_process)
        val set = ProcessUtils.getAllBackgroundProcesses()
        tvAboutProcess!!.text = SpanUtils()
                .appendLine("getForegroundProcessName: " + ProcessUtils.getForegroundProcessName()!!)
                .appendLine("getAllBackgroundProcesses: " + getSetItems(set))
                .appendLine("size: " + set.size)
                .appendLine("isMainProcess: " + ProcessUtils.isMainProcess())
                .append("getCurrentProcessName: " + ProcessUtils.getCurrentProcessName()!!)
                .create()
    }

    override fun doBusiness() {

    }

    @SuppressLint("MissingPermission")
    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_kill_all_background_processes) {
            val set = ProcessUtils.getAllBackgroundProcesses()
            val set1 = ProcessUtils.killAllBackgroundProcesses()
            tvAboutProcess!!.text = SpanUtils()
                    .appendLine("getForegroundProcessName: " + ProcessUtils.getForegroundProcessName()!!)
                    .appendLine("getAllBackgroundProcesses: " + getSetItems(set))
                    .appendLine("size: " + set.size)
                    .appendLine("killAllBackgroundProcesses: " + getSetItems(set1))
                    .appendLine("size: " + set1.size)
                    .appendLine("isMainProcess: " + ProcessUtils.isMainProcess())
                    .append("getCurrentProcessName: " + ProcessUtils.getCurrentProcessName()!!)
                    .create()

        }
    }

    private fun getSetItems(set: Set<String>): String {
        val iterator = set.iterator()
        val sb = StringBuilder()
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append("\n")
        }
        return sb.toString()
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, ProcessActivity::class.java)
            context.startActivity(starter)
        }
    }
}
