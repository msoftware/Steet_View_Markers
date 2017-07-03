package com.keypr.gapp.ui.activities

import com.alkurop.mystreetplaces.ui.activities.ActivityRoot
import com.alkurop.mystreetplaces.ui.activities.DefaultActivityRoot
import dagger.Binds
import dagger.Module

/** Provides default activity root. */
@Module
abstract class ActivityRootModule {

  @Binds
  internal abstract fun activityRoot(root: DefaultActivityRoot): ActivityRoot

}
