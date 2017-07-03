package com.alkurop.mystreetplaces.social.login.base

import com.alkurop.mystreetplaces.social.login.LoginSuccess


interface SocialCallback {
  fun onSuccess(result: LoginSuccess)

  fun onError(exception: Exception)

  fun onLogOut()
}
