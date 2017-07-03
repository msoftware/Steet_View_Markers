package com.alkurop.mystreetplaces.ui.home

import com.alkurop.mystreetplaces.ui.createNavigationSubject
import com.alkurop.mystreetplaces.ui.createViewSubject
import com.alkurop.mystreetplaces.ui.login.LoginActivity
import com.alkurop.mystreetplaces.ui.navigation.ActivityNavigationAction
import com.alkurop.mystreetplaces.ui.navigation.NavigationAction
import io.reactivex.subjects.Subject


class MainActivityPresenterImpl : MainActivityPresenter {
  override val viewBus: Subject<MainModel> = createViewSubject()
  override val navBus: Subject<NavigationAction> = createNavigationSubject()

  override fun onLoginButton() {
    val navigation = ActivityNavigationAction(LoginActivity::class.java)
    navBus.onNext(navigation)
  }

  override fun unsubscribe() {
  }
}
