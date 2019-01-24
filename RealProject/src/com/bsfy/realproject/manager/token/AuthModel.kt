package com.bsfy.realproject.manager.token

import java.io.Serializable

class AuthModel : Serializable {
    var id: Int = 0
    var url: String? = null
    var token: String? = null
}
