package com.alkurop.mystreetplaces.repo

import com.facebook.AccessToken
import io.reactivex.Single


class LoginRepoImpl : LoginRepo {
  override fun isLoggedIn(): Single<Boolean> {
    val accessToken = AccessToken.getCurrentAccessToken()
    return Single.just(accessToken != null)
  }
}
