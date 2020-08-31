package com.ase21.somenetworkingoncoroutines

import com.ase21.somenetworkingoncoroutines.data.ShopRateDTO
import retrofit2.http.GET

interface RetrofitApi {

    @GET("letters")
    suspend fun getAllCommentsWithAnswers():List<ShopRateDTO?>
}