package dev.devlopment.cryptocurrencytraker.Core.Domain.Utils

enum class NetworkError:Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    SERVER_ERROR,
    NO_INTERNET_CONNECTION,
    SERIALIZATION,
    UNKNOWN_ERROR
}