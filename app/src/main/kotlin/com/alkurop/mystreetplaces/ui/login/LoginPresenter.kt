package com.alkurop.mystreetplaces.ui.login

import com.alkurop.mystreetplaces.social.login.base.SocialCallback
import com.alkurop.mystreetplaces.ui.navigation.NavigationAction
import io.reactivex.subjects.Subject


interface LoginPresenter : SocialCallback {
  val viewBus: Subject<LoginModel>

  val navBus: Subject<NavigationAction>

  fun unsubscrube()
}
