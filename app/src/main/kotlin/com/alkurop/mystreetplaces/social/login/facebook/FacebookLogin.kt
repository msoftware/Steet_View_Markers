package com.alkurop.mystreetplaces.social.login.facebook

import android.app.Activity
import android.content.Intent
import android.util.Log
import com.alkurop.mystreetplaces.social.login.LoginSuccess
import com.alkurop.mystreetplaces.social.login.base.SocialCallback
import com.alkurop.mystreetplaces.social.login.base.SocialLogin
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*

class FacebookLogin : SocialLogin {

  val mFbCallbackManager: CallbackManager = CallbackManager.Factory.create()

  lateinit var mActivity: Activity

  lateinit var mCallback: SocialCallback


  override fun setUp(activity: Activity, callback: SocialCallback) {
    this.mActivity = activity
    this.mCallback = callback
    registerCallback()
  }

  private fun registerCallback() {
    LoginManager.getInstance().registerCallback(mFbCallbackManager, object : FacebookCallback<LoginResult> {
      override fun onSuccess(loginResult: LoginResult) {
        mCallback.onSuccess(LoginSuccess(loginResult.accessToken.userId,
            loginResult.accessToken.token))

      }

      override fun onCancel() {
        Log.d(TAG, "user canceled login")
      }

      override fun onError(exception: FacebookException) {
        mCallback.onError(exception)
      }
    })
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

  companion object {
    val TAG = FacebookLogin::class.java.simpleName
  }
}
