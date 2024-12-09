package dev.devlopment.cryptocurrencytraker.Core.Navigation

import android.widget.Toast
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.devlopment.cryptocurrencytraker.Core.Presentation.Utils.ObserveAsEvents
import dev.devlopment.cryptocurrencytraker.Core.Presentation.Utils.toString
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList.CoinListAction
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList.CoinListEvent
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList.CoinListScreen
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.CoinList.CoinListViewModel
import dev.devlopment.cryptocurrencytraker.Crypto.Presentation.Coin_detail.CoinDetailScreen
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AdaptiveCoinListDetailPane(
    viewModel: CoinListViewModel= koinViewModel(),
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    ObserveAsEvents(events = viewModel.events) {event->
        when(event){
            is CoinListEvent.Error ->{
                Toast.makeText(
                    context,
                    event.error.toString(context),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
    val navigator= rememberListDetailPaneScaffoldNavigator<Any>()
    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            AnimatedPane {
                CoinListScreen(
                    state = state,
                    onAction = {action->
                        viewModel.onAction(action)
                        when(action){
                            is CoinListAction.OnCoinClick ->{
                                navigator.navigateTo(
                                    pane = ListDetailPaneScaffoldRole.Detail
                                )
                            }
                        }
                    }
                )
            }
        },
        detailPane ={
            AnimatedPane {
                CoinDetailScreen(
                    state = state
                )
            }
        },
        modifier = modifier
    )
}