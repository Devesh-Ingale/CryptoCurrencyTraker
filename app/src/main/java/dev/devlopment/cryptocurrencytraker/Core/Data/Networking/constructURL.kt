package dev.devlopment.cryptocurrencytraker.Core.Data.Networking

import dev.devlopment.cryptocurrencytraker.BuildConfig

fun constructURL(url:String):String{
    return when
    {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.removePrefix("/")
        else -> BuildConfig.BASE_URL + url
    }
}