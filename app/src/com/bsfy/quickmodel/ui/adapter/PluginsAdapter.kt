package com.bsfy.quickmodel.ui.adapter

import android.widget.TextView
import com.bsfy.quickmodel.PluginItem
import com.bsfy.quickmodel.R
import com.bsfy.superpluginmodel.dynamicload.internal.DLIntent
import com.bsfy.superpluginmodel.dynamicload.internal.DLPluginManager
import com.bsfy.superweightmodel.baseview.rv.BaseViewHolder
import org.jetbrains.anko.find

/**
 * 作者: Created by bsfy on 2019/1/3.
 */

class PluginsAdapter(list: List<PluginItem>, layoutId: Int) : XBaseAdapter<PluginItem>(list, layoutId) {

    override fun bind(holder: BaseViewHolder, data: PluginItem) {
        super.bind(holder, data)

        holder.itemView.find<TextView>(R.id.tv_title).text = data.packageInfo.packageName

        holder.itemView.setOnClickListener({
            val pluginManager = DLPluginManager.getInstance(mContext)
            pluginManager.startPluginActivity(mContext, DLIntent(data.packageInfo.packageName))

        })

    }
}