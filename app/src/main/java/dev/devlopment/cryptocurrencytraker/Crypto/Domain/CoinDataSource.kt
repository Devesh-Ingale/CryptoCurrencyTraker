package dev.devlopment.cryptocurrencytraker.Crypto.Domain

import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.NetworkError
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>,NetworkError>
    suspend fun getCoinHistory(
        coinId:String,
        start:ZonedDateTime,
        end:ZonedDateTime
    ):Result<List<CoinPrice>,NetworkError>
}