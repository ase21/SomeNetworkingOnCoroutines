package com.ase21.somenetworkingoncoroutines.data

import com.google.gson.annotations.SerializedName

data class ShopRateDTO(
    @SerializedName("id") var id: Int?,
    @SerializedName("text") var text: String?,
    @SerializedName("city") var city: String?,
    @SerializedName("shop_id") var shopId: String?,
    @SerializedName("shop_score") var shopScore: String?,
    @SerializedName("service_score") var serviceScore: String?
)
