package org.example.jetpack_compose_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import org.example.jetpack_compose_2.ui.theme.Jetpack_compose_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComponent()
        }

    }
}
@Composable
fun MyComponent(){
    Row {
        MyImage()
        MyTexts()
    }
}
@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
              "Mi imagen de prueba"
        )
}
@Composable
fun MyTexts(){
    Column() {
        MyText("Hola Hola")
        MyText("Mundi mundo")

    }
}
@Composable
fun MyText(text: String){
    Text(text)
}

@Preview
@Composable
fun PreviewComponent(){
    MyComponent()
}


