package uz.turgunboyevjurabek.retrofitagain.networking

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    const val BASE_URL="https://jsonplaceholder.typicode.com/"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun getApiServis(context: Context):ApiServis{
        return getRetrofit().create(ApiServis::class.java)
    }

}