package dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO

import kotlinx.serialization.Serializable

@Serializable
data class CoinHistoryDTO(
    val data:List<CoinPriceDTO>
)
