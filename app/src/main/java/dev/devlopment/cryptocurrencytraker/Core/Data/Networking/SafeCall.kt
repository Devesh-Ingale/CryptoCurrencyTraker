package dev.devlopment.cryptocurrencytraker.Core.Data.Networking

import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.NetworkError
import dev.devlopment.cryptocurrencytraker.Core.Domain.Utils.Result
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import org.jetbrains.annotations.Async.Execute
import kotlin.coroutines.coroutineContext

suspend inline fun <reified  T> SafeCall(
    execute: () -> HttpResponse
):Result<T, NetworkError> {
    val response = try {
        execute()
    }catch (e:UnresolvedAddressException){
        return Result.Error(NetworkError.NO_INTERNET_CONNECTION)
    } catch (e: SerializationException) {
        return Result.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(NetworkError.UNKNOWN_ERROR)
    }
    return ResponseToResult(response)
}