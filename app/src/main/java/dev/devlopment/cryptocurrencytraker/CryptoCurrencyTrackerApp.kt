package dev.devlopment.cryptocurrencytraker

import android.app.Application
import dev.devlopment.cryptocurrencytraker.DependencyInjection.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptoCurrencyTrackerApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@CryptoCurrencyTrackerApp)
            androidLogger()

            modules(AppModule)
        }
    }
}