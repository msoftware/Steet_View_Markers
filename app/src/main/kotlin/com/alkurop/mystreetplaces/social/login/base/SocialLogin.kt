package com.alkurop.mystreetplaces.social.login.base

import android.app.Activity
import android.content.Intent


interface SocialLogin {
  fun signIn()

  fun signOut()

  fun onActivityResult(request: Int, response: Int, data: Intent?)

  fun setUp(activity: Activity, callback: SocialCallback)
  fun destroy()
}
