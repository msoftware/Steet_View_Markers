package com.alkurop.mystreetplaces.di.modules

import com.alkurop.mystreetplaces.di.annotations.Facebook
import com.alkurop.mystreetplaces.social.login.base.SocialLogin
import com.alkurop.mystreetplaces.social.login.facebook.FacebookLogin
import dagger.Module
import dagger.Provides


@Module
open class UtilityModule {

  @Provides @Facebook fun provideFacebookLogin(): SocialLogin {
    return FacebookLogin()
  }

}
