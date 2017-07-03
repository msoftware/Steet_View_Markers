package com.alkurop.mystreetplaces.ui.home

import com.alkurop.mystreetplaces.repo.LoginRepo
import com.alkurop.mystreetplaces.ui.createNavigationSubject
import com.alkurop.mystreetplaces.ui.createViewSubject
import com.alkurop.mystreetplaces.ui.login.LoginActivity
import com.alkurop.mystreetplaces.ui.navigation.ActivityNavigationAction
import com.alkurop.mystreetplaces.ui.navigation.NavigationAction
import com.facebook.AccessToken
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Timed
import io.reactivex.subjects.Subject
import timber.log.Timber
import java.util.*


class MainActivityPresenterImpl(val loginRepo: LoginRepo) : MainActivityPresenter {
  val subs = CompositeDisposable()
  override fun start() {
    //todo remove
    startLogInActivity()
   /* val sub = loginRepo
        .isLoggedIn()
        .subscribeOn(Schedulers.io())
        .subscribe({
          if (!it) startLogInActivity()
        }, {
          Timber.e(it)

        })
    subs.add(sub)*/
  }

  override val viewBus: Subject<MainModel> = createViewSubject()
  override val navBus: Subject<NavigationAction> = createNavigationSubject()

  fun startLogInActivity() {
    val navigation = ActivityNavigationAction(LoginActivity::class.java)
    navBus.onNext(navigation)
  }

  override fun unsubscribe() {
    subs.clear()
  }
}
