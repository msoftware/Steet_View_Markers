package com.alkurop.mystreetplaces.di.modules

import com.alkurop.mystreetplaces.repo.LoginRepo
import com.alkurop.mystreetplaces.repo.LoginRepoImpl
import dagger.Module
import dagger.Provides


@Module
open class RepoModule {

  @Provides fun provideLoginRepo(): LoginRepo {
    return LoginRepoImpl()
  }
}
