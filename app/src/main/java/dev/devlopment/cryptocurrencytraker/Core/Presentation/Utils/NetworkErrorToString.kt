package dev.devlopment.cryptocurrencytraker.Core.Presentation.Utils

import android.content.Context
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.NetworkError
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.NetworkError.*
import dev.devlopment.cryptocurrencytraker.R

fun NetworkError.toString(context: Context):String{
    val resId= when(this){
        REQUEST_TIMEOUT -> R.string.error_request_timeout
        TOO_MANY_REQUESTS -> R.string.error_too_many_requests
        SERVER_ERROR -> R.string.error_server_error
        NO_INTERNET_CONNECTION -> R.string.error_no_internet_connection
        SERIALIZATION -> R.string.error_serialization
        UNKNOWN_ERROR -> R.string.error_unknown_error
    }
    return context.getString(resId)
}