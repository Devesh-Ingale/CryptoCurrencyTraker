package dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO

import kotlinx.serialization.Serializable

@Serializable
data class CoinResponseDTO(
    val data:List<CoinDTO>
)
