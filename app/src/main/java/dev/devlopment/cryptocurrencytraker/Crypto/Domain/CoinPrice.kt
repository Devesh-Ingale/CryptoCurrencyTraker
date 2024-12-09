package dev.devlopment.cryptocurrencytraker.Crypto.Domain

import java.time.ZonedDateTime

data class CoinPrice(
    val priceUsd:Double,
    val dateTime: ZonedDateTime
)
