package com.alkurop.mystreetplaces.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alkurop.mystreetplaces.R
import com.alkurop.mystreetplaces.di.annotations.PerActivity
import com.alkurop.mystreetplaces.ui.base.BaseMvpActivity
import com.alkurop.mystreetplaces.ui.navigation.NavigationAction
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseMvpActivity<MainModel>() {
  @Inject lateinit var presenter: MainActivityPresenter

  override fun getSubject(): Observable<MainModel> = presenter.viewBus
  override fun getNavigation(): Observable<NavigationAction> = presenter.navBus

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    component().inject(this)
    setContentView(R.layout.activity_main)
    login.setOnClickListener { presenter.onLoginButton() }
  }

  override fun renderView(viewModel: MainModel) {
  }

  override fun unsubscribe() {
    presenter.unsubscribe()
  }
}
