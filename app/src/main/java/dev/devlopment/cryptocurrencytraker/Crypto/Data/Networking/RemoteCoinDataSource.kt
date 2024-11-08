package dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking

import dev.devlopment.cryptocurrencytraker.Core.Data.Networking.ConstructURL
import dev.devlopment.cryptocurrencytraker.Core.Data.Networking.SafeCall
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.NetworkError
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.Result
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.map
import dev.devlopment.cryptocurrencytraker.Crypto.Data.Mappers.toCoin
import dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.DTO.CoinResponseDTO
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.Coin
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get


class RemoteCoinDataSource (
    private val httpClient: HttpClient
):CoinDataSource{
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return SafeCall<CoinResponseDTO> {
           httpClient.get(
               urlString = ConstructURL("/assets")
           )
        }.map { response->
            response.data.map {
                it.toCoin()
            }
        }
    }

}