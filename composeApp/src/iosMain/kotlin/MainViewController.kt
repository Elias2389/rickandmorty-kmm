import androidx.compose.ui.window.ComposeUIViewController
import core.di.appModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { App() }

fun initKoin() {
    startKoin {
        modules(listOf(
            appModule()
        ))
    }.koin
}
