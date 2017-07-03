package com.alkurop.mystreetplaces.ui.home

import com.alkurop.mystreetplaces.ui.navigation.NavigationAction
import io.reactivex.subjects.Subject

interface MainActivityPresenter {
  val viewBus: Subject<MainModel>
  val navBus: Subject<NavigationAction>

  fun unsubscribe()

  fun start()
}
