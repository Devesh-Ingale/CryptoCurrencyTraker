package dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList

import androidx.compose.runtime.Immutable
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.Models.CoinUi

@Immutable
data class CoinListState(
    val isLoading:Boolean=false,
    val coins:List<CoinUi> = emptyList(),
    val selectedCoin:CoinUi?=null
)
