package dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList

import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.Models.CoinUi

sealed interface CoinListAction {
    data class onCoinClick(val coinUi:CoinUi):CoinListAction
    data object onRefresh:CoinListAction
}