package dev.devlopment.cryptocurrencytraker.Crypto.Domain

import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.NetworkError
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>,NetworkError>
}