package dev.devlopment.cryptocurrencytraker.Crypto.Data.Mappers

import dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO.CoinDTO
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.Coin

fun CoinDTO.toCoin():Coin{
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}