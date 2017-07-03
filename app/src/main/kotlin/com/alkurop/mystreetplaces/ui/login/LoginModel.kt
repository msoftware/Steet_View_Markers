package com.alkurop.mystreetplaces.ui.login

import com.alkurop.mystreetplaces.social.login.LoginSuccess


data class LoginModel(val isLoading: Boolean? = null,
                      val login: LoginSuccess? = null,
                      val error: Exception? = null)
