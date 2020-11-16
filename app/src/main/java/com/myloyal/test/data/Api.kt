package com.myloyal.test.data

import com.myloyal.test.models.Currency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("coins/markets")
    suspend fun getData(@Query("vs_currency") currency: String ): List<Currency>

}