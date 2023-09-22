package uz.turgunboyevjurabek.retrofitagain.networking

import android.telecom.Call
import retrofit2.http.GET
import uz.turgunboyevjurabek.retrofitagain.madels.ApiGet

interface ApiServis {
    @GET("posts/")
   suspend fun getAllItem():retrofit2.Call<List<ApiGet>>

}