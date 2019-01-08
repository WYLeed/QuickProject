package com.bsfy.quickmodel

import android.content.Context
import com.bsfy.httpmodel.SuperHttpManager
import com.bsfy.httpmodel.cache.converter.SerializableDiskConverter
import com.bsfy.httpmodel.model.HttpHeaders
import com.bsfy.httpmodel.model.HttpParams
import com.bsfy.httpmodel.utils.HttpLog
import com.bsfy.quickmodel.manager.interceptor.CustomSignInterceptor
import com.bsfy.superweightmodel.BaseApp
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

/**
 * 作者: Created by wangyu on 2019/1/2.
 */

class LocalApplication : BaseApp() {


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        SuperHttpManager.init(this)

        initHttp()
    }

    private fun initHttp() {
        val headers = HttpHeaders()
        val params = HttpParams()
        SuperHttpManager.getInstance()
                .debug("SuperHttpManager", true)
                .setReadTimeOut(15 * 1000)
                .setWriteTimeOut(15 * 1000)
                .setConnectTimeout(15 * 1000)
                .setRetryCount(3)                                     //默认网络不好自动重试3次
                .setRetryDelay(500)                                   //每次延时500ms重试
                .setRetryIncreaseDelay(500)                           //每次延时叠加500ms
                .setBaseUrl(SuperHttpManager.BASE_URL)
                .setCacheDiskConverter(SerializableDiskConverter())   //默认缓存使用序列化转化
                .setCacheMaxSize(100 * 1024 * 1024)                   //设置缓存大小为50M
                .setCacheVersion(1)                                   //缓存版本为1
                .setHostnameVerifier(UnSafeHostnameVerifier(SuperHttpManager.BASE_URL))//全局访问规则
                .setCertificates()                                    //信任所有证书
                .addCommonHeaders(headers)                            //设置全局公共头
                .addCommonParams(params)                              //设置全局公共参数
                .addInterceptor(CustomSignInterceptor())              //添加参数签名拦截器
        //.addInterceptor(new HeTInterceptor());//处理自己业务的拦截器
    }

    inner class UnSafeHostnameVerifier(private val host: String?) : HostnameVerifier {
        init {
            HttpLog.i("UnSafeHostnameVerifier " + host)
        }

        override fun verify(hostname: String, session: SSLSession): Boolean {
            HttpLog.i("verify " + hostname + " " + this.host)
            return !(this.host == null || "" == this.host || !this.host.contains(hostname))
        }
    }
}
