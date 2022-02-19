package com.example.retrofit_zidan_34.model

import com.google.gson.annotations.SerializedName

data class Province(
    @SerializedName("Kode Provi")
    val code: Int,
    @SerializedName("Profinsi")
    val province: String,
    @SerializedName("Kasus_Posi")
    val positif: Int,
    @SerializedName("Kasus_Sembuh")
    val sembuh: Int,
    @SerializedName("Kasus_Meni")
    val death: Int,
)