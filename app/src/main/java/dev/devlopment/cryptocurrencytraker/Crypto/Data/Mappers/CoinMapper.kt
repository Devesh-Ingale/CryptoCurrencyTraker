package dev.devlopment.cryptocurrencytraker.Crypto.Data.Mappers

import dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO.CoinDTO
import dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO.CoinPriceDTO
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.Coin
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

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

fun CoinPriceDTO.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}