package com.bsfy.quickmodel.entity.request

import com.bsfy.quickmodel.BuildConfig
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * 作者: Created by bsfy on 2019/1/8.
 */
class LoginRequest {

    var scopes: List<String>? = null
        private set
    var note: String? = null
        private set
    @SerializedName("client_id")
    var clientId: String? = null
        private set
    @SerializedName("client_secret")
    var clientSecret: String? = null
        private set

    companion object {
        open fun generate(): LoginRequest {
            val model = LoginRequest()
            model.scopes = Arrays.asList("user", "repo", "gist", "notifications")
            model.note = BuildConfig.APPLICATION_ID
            model.clientId = "47b14cd02abf860fb8e0"
            model.clientSecret = "3872f841b307d16763fc2b48c566b95b89933c96"
            return model
        }
    }
}
