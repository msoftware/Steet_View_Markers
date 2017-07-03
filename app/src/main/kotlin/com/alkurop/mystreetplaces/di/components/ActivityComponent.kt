package com.alkurop.mystreetplaces.di.components

import com.alkurop.mystreetplaces.di.annotations.PerActivity
import com.alkurop.mystreetplaces.di.modules.ActivityModule
import com.alkurop.mystreetplaces.ui.home.MainActivity
import com.alkurop.mystreetplaces.ui.login.LoginActivity
import com.keypr.gapp.ui.activities.ActivityRootModule
import dagger.Subcomponent

/** Injects activities.  */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class, ActivityRootModule::class))
interface ActivityComponent {

  fun inject(activity: LoginActivity)

  fun inject(activity: MainActivity)
}

