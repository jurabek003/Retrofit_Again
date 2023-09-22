package uz.turgunboyevjurabek.retrofitagain.madels


import com.google.gson.annotations.SerializedName

data class ApiGet(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)