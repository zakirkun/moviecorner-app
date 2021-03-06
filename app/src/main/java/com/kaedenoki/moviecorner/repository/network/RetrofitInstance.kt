package com.kaedenoki.moviecorner.repository.network

import com.kaedenoki.moviecorner.repository.network.anime.AnimeContract
import com.kaedenoki.moviecorner.repository.network.series.SeriesContract
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val baseSeries: Retrofit = Retrofit.Builder()
        .baseUrl("https://drakor-corner.azurewebsites.net/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val baseAnime: Retrofit = Retrofit.Builder()
        .baseUrl("https://anime-corner.azurewebsites.net/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getSeriesClient(): SeriesContract = baseSeries.create(SeriesContract::class.java)
    fun getAnimeClient(): AnimeContract = baseAnime.create(AnimeContract::class.java)
}
