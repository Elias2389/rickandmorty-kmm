import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import characterlist.presentation.component.CharacterListScreen
import moe.tlaster.precompose.PreComposeApp
import org.koin.compose.KoinContext

@Composable
fun App() {
    PreComposeApp {
        KoinContext {
            MaterialTheme {
                CharacterListScreen()
            }
        }
    }
}