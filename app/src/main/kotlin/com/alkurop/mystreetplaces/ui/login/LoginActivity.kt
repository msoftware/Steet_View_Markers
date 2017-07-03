package com.alkurop.mystreetplaces.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.alkurop.mystreetplaces.R
import com.alkurop.mystreetplaces.di.annotations.Facebook
import com.alkurop.mystreetplaces.social.login.LoginSuccess
import com.alkurop.mystreetplaces.social.login.base.SocialCallback
import com.alkurop.mystreetplaces.social.login.base.SocialLogin
import com.alkurop.mystreetplaces.ui.base.BaseMvpActivity
import com.alkurop.mystreetplaces.ui.navigation.NavigationAction
import io.reactivex.Observable
import javax.inject.Inject

class LoginActivity : BaseMvpActivity<LoginModel>() {

  @Inject lateinit var presenter: LoginPresenter
  @field:[Facebook] @Inject lateinit var facebookLogin: SocialLogin


  override fun getSubject(): Observable<LoginModel> = presenter.viewBus

  override fun getNavigation(): Observable<NavigationAction> = presenter.navBus

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    component().inject(this)
    setContentView(R.layout.activity_login)
    facebookLogin.setUp(this, presenter)
  }

  override fun renderView(viewModel: LoginModel) {
    Toast.makeText(this, "$viewModel", Toast.LENGTH_SHORT).show()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    facebookLogin.onActivityResult(requestCode, resultCode, data)
  }


  override fun unsubscribe() {
    presenter.unsubscrube()
  }
}
