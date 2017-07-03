package com.alkurop.mystreetplaces.di.modules

import com.alkurop.mystreetplaces.ui.home.MainActivityPresenter
import com.alkurop.mystreetplaces.ui.home.MainActivityPresenterImpl
import com.alkurop.mystreetplaces.ui.login.LoginPresenter
import com.alkurop.mystreetplaces.ui.login.LoginPresenterImpl
import dagger.Module
import dagger.Provides


@Module
class PresenterModule {
  @Provides fun provideLoginPresenter(): LoginPresenter {
    return LoginPresenterImpl()
  }

  @Provides fun provideMainPresenter(): MainActivityPresenter {
    return MainActivityPresenterImpl()
  }

}

