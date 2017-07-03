package com.alkurop.mystreetplaces.social.login.facebook

import android.app.Activity
import android.content.Intent
import com.alkurop.mystreetplaces.social.login.LoginSuccess
import com.alkurop.mystreetplaces.social.login.base.SocialCallback
import com.alkurop.mystreetplaces.social.login.base.SocialLogin
import com.facebook.AccessToken
import com.facebook.AccessTokenTracker
import com.facebook.CallbackManager
import com.facebook.login.LoginManager
import java.util.*

class FacebookLogin : SocialLogin {

  val mFbCallbackManager: CallbackManager = CallbackManager.Factory.create()
  lateinit var mActivity: Activity
  lateinit var mCallback: SocialCallback

  var att: AccessTokenTracker? = null

  override fun setUp(activity: Activity, callback: SocialCallback) {
    this.mActivity = activity
    this.mCallback = callback
    registerCallback()
  }


  override fun destroy() {
    att?.stopTracking()
  }

  private fun registerCallback() {
    att = object : AccessTokenTracker() {
      override fun onCurrentAccessTokenChanged(oldAccessToken: AccessToken?, currentAccessToken: AccessToken?) {
        if (currentAccessToken == null || currentAccessToken.isExpired || currentAccessToken.token == null) {
          mCallback.onLogOut()
        } else {
          mCallback.onSuccess(LoginSuccess(currentAccessToken.userId,
              currentAccessToken.token))
        }
      }
    }
    att?.startTracking()

  }

  override fun signOut() {
    LoginManager.getInstance().logOut()
  }

  override fun signIn() {
    val permissions = ArrayList<String>()
    permissions.add(FacebookConstants.email)
    permissions.add(FacebookConstants.public_profile)
    LoginManager.getInstance().logInWithReadPermissions(mActivity, permissions)
  }

  override fun onActivityResult(request: Int, response: Int, data: Intent?) {
    mFbCallbackManager.onActivityResult(request, response, data)
  }
}
