package org.example.jetpack_compose_2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.jetpack_compose_2.ui.theme.Jetpack_compose_2Theme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_compose_2Theme() {
                MyComponent()
            }

        }

    }
}
@Composable
fun MyComponent(){
    Row (modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)
    )
    {
        MyImage()
        MyTexts()
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
fun MyTexts(){
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText("Hola Hola",
                MaterialTheme.colors.primaryVariant,

            )
        Spacer(modifier = Modifier.height(16.dp))
        MyText("Mundo mundo",
        MaterialTheme.colors.onBackground,


            )

    }
}
@Composable
fun MyText(text: String, color: Color){
    Text(text, color = color)
}



@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent(){
    Jetpack_compose_2Theme() {
        MyComponent()
    }

}


