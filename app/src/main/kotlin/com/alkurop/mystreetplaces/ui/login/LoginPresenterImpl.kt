package com.alkurop.mystreetplaces.ui.login

import com.alkurop.mystreetplaces.social.login.LoginSuccess
import com.alkurop.mystreetplaces.ui.createNavigationSubject
import com.alkurop.mystreetplaces.ui.createViewSubject
import com.alkurop.mystreetplaces.ui.navigation.NavigationAction
import io.reactivex.subjects.Subject
import timber.log.Timber

class LoginPresenterImpl : LoginPresenter {

  override val viewBus: Subject<LoginModel> = createViewSubject()
  override val navBus: Subject<NavigationAction> = createNavigationSubject()

  override fun onSuccess(result: LoginSuccess) {
    val model = LoginModel(login = result)
    viewBus.onNext(model)
  }

  override fun onError(exception: Exception) {
    Timber.e(exception)
    val model = LoginModel(error = exception)
    viewBus.onNext(model)
  }

  override fun unsubscrube() {
  }
}
