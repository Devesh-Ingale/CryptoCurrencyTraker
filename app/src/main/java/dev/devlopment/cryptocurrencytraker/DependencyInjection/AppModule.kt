package dev.devlopment.cryptocurrencytraker.DependencyInjection

import dev.devlopment.cryptocurrencytraker.Core.Data.Networking.HttpClientFactory
import dev.devlopment.cryptocurrencytraker.Crypto.Data.Networking.RemoteCoinDataSource
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.CoinDataSource
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val AppModule= module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}