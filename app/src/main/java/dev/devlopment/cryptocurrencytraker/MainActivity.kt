package dev.devlopment.cryptocurrencytraker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList.CoinListScreen
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList.CoinListViewModel
import dev.devlopment.cryptocurrencytraker.ui.theme.CryptoCurrencyTrakerTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoCurrencyTrakerTheme {
                Scaffold(modifier = Modifier.fillMaxSize().padding(top = 36.dp)){ innerPadding ->
                    val viewModel= koinViewModel<CoinListViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    CoinListScreen(
                        modifier = Modifier.padding(innerPadding),
                        state = state
                    )
                }
            }
        }
    }
}
