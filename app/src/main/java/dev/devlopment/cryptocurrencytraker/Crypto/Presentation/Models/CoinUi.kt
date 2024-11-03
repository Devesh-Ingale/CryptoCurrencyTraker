package dev.devlopment.cryptocurrencytraker.Crypto.Presentation.Models

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import dev.devlopment.cryptocurrencytraker.Crypto.Domain.Coin
import dev.devlopment.cryptocurrencytraker.Core.Presentation.Utils.getDrawableIdForCoin
import java.util.Locale

data class CoinUi(
    val id:String,
    val rank:Int,
    val name:String,
    val symbol:String,
    val marketCapUsd:DisplayableNumber,
    val priceUsd:DisplayableNumber,
    val changePercent24Hr:DisplayableNumber,
    @DrawableRes val iconRes:Int
)

data class DisplayableNumber(
    val value:Double,
    val formatted:String
)

fun Coin.toCoinUi():CoinUi{
    return CoinUi(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        priceUsd = priceUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber():DisplayableNumber{
    val formatter= NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits=2
        maximumFractionDigits=2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}