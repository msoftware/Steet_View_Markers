package com.alkurop.mystreetplaces.repo

import io.reactivex.Single

interface LoginRepo {
  fun isLoggedIn(): Single<Boolean>
}
