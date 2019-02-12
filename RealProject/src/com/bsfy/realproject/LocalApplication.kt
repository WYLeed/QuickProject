package com.bsfy.realproject

import android.content.Context
import com.bsfy.httpmodel.SuperHttpManager
import com.bsfy.httpmodel.cache.converter.SerializableDiskConverter
import com.bsfy.httpmodel.model.HttpHeaders
import com.bsfy.httpmodel.model.HttpParams
import com.bsfy.httpmodel.utils.HttpLog
import com.bsfy.realproject.manager.interceptor.PageInfoInterceptor
import com.bsfy.realproject.utils.XPreference
import com.bsfy.superweightmodel.BaseApp
import okhttp3.Interceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

/**
 * 作者: Created by bsfy on 2019/1/2.
 */

class LocalApplication : BaseApp() {

    private var accessTokenStorage: String by XPreference("", "af6d31e3774930e3ceb0c83e696e58bb7848276f")

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

        headers.put("Accept", "application/json")
        headers.put("Content-Type", "application/json; charset=UTF-8")
        headers.put("platform", "saas-android")

        val params = HttpParams()


        SuperHttpManager.getInstance()
                .debug("SuperHttpManager", true)
                .setReadTimeOut(15 * 1000)
                .setWriteTimeOut(15 * 1000)
                .setConnectTimeout(15 * 1000)
                .setRetryCount(2)                                     //默认网络不好自动重试3次
                .setRetryDelay(500)                                   //每次延时500ms重试
                .setRetryIncreaseDelay(500)                           //每次延时叠加500ms
                .setBaseUrl(SuperHttpManager.BASE_URL)
                .setCacheDiskConverter(SerializableDiskConverter())   //默认缓存使用序列化转化
                .setCacheMaxSize(100 * 1024 * 1024)                   //设置缓存大小为50M
                .setCacheVersion(1)                                   //缓存版本为1
                .addCommonHeaders(headers)                            //设置全局公共头
                .addCommonParams(params)                              //设置全局公参数
                .addInterceptor(headerInterceptor())
                .addInterceptor(PageInfoInterceptor())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

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

    /**
     * 拦截头部增加token
     */
    private fun headerInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()

            //add access token
            val accessToken = accessTokenStorage
            if (!accessToken.isEmpty()) {
                val url = request.url().toString()
                request = request.newBuilder()
                        .addHeader("Authorization", accessToken)
                        .url(url)
                        .build()
            }

            chain.proceed(request)
        }

    }
}
