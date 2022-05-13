package org.example.jetpack_compose_2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.jetpack_compose_2.ui.theme.Jetpack_compose_2Theme
import java.time.format.TextStyle

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Mundo1", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Hola Mundo2", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et"),
    MyMessage("Hola Mundo3", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et"),
    MyMessage("Hola Mundo4", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"),
    MyMessage("Hola Mundo5", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"),
    MyMessage("Hola Mundo6", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"),
    MyMessage("Hola Mundo7", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"),
    MyMessage("Hola Mundo8", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
    MyMessage("Hola Mundo9", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
    MyMessage("Hola Mundoa", "Estas listo Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
    MyMessage("Hola Mundob", "Estas listo"),
    MyMessage("Hola Mundoc", "Estas listo"),
    MyMessage("Hola Mundod", "Estas listo"),
    MyMessage("Hola Mundoe", "Estas listo"),
    MyMessage("Hola Mundof", "Estas listo"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_compose_2Theme() {
                MyMessages(messages)
            }

        }

    }
}

data class MyMessage(val title: String, val body: String)
@Composable
fun MyMessages(message: List<MyMessage>){
    LazyColumn{
        items(message) {message ->
            MyComponent(message)
        }
    }
}
@Composable
fun MyComponent(message: MyMessage){
    Row (modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)
    )
    {
        MyImage()
        MyTexts(message)
    }
}
@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
              "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp)
        )
}
@Composable
fun MyTexts(message: MyMessage){
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(start = 8.dp).clickable {
       expanded = !expanded
    }) {
        MyText(
            message.title,
            MaterialTheme.colors.primaryVariant

            )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
        MaterialTheme.colors.onBackground,
            if(expanded) Int.MAX_VALUE else 1
            )

    }
}
@Composable
fun MyText(text: String, color: Color, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, maxLines = lines)
}



@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent(){
    Jetpack_compose_2Theme {

        MyMessages(messages)
      /*  val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
        }*/
    }

}


