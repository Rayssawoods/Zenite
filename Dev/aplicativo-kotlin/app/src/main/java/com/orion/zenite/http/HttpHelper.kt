package com.orion.zenite.http

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HttpHelper {

    // Definir a URL do servidor coloque o IP da sua maquina no lugar de localhost
    // AWS: "http://3.86.5.222:8080",
    // Azure: "https://zenitebackend.azurewebsites.net",

    private val URL =  "http://192.168.15.12:8080"
    var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }



}