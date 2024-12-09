package dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking

import dev.devlopment.cryptocurrencytraker.Core.Data.Networking.constructURL
import dev.devlopment.cryptocurrencytraker.Core.Data.Networking.safeCall
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.NetworkError
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.Result
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.map
import dev.devlopment.cryptocurrencytraker.Crypto.Data.Mappers.toCoin
import dev.devlopment.cryptocurrencytraker.Crypto.Data.Mappers.toCoinPrice
import dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO.CoinHistoryDTO
import dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO.CoinResponseDTO
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.Coin
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.CoinDataSource
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime


class RemoteCoinDataSource (
    private val httpClient: HttpClient
):CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDTO> {
            httpClient.get(
                urlString = constructURL("/assets")
            )
        }.map { response ->
            response.data.map {
                it.toCoin()
            }
        }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDTO> {
            httpClient.get(
                urlString = constructURL("/assets/$coinId/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map {
                it.toCoinPrice()
            }
        }
    }
}