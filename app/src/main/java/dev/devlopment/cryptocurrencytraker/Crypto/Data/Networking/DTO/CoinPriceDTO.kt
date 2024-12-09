package dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO

import kotlinx.serialization.Serializable

@Serializable
data class CoinPriceDTO(
    val priceUsd:Double,
    val time:Long
)
