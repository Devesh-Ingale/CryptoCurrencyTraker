package dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList

import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.Models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi:CoinUi):CoinListAction
}