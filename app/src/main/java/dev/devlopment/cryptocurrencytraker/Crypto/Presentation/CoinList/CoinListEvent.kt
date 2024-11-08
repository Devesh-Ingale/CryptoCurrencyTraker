package dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList

import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.NetworkError


sealed interface CoinListEvent {
    data class Error(val error:NetworkError):CoinListEvent
}