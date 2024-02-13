package characterlist.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun CharacterCard(
    imageUrl: String = ""
) {
    val image = imageUrl.ifEmpty { "https://picsum.photosimage/id/1/200/300" }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(modifier = Modifier.width(60.dp)) {
            val painter = asyncPainterResource(data = image)
            KamelImage(
                resource = painter,
                contentDescription = "test",
            )
        }
    }
}
//https://rickandmortyapi.com/api/character/avatar/1.jpeg

//@Composable
//fun CharacterCardPreview() {
//    RickAndMortyComposeMVITheme {
//        Column {
//            CharacterCard()
//            Spacer(modifier = Modifier.height(12.dp))
//            CharacterCard()
//        }
//
//    }
//}