package fi.ulla.mymorning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.ulla.mymorning.ui.theme.MyOwnTheme
import fi.ulla.mymorning.ui.theme.MymorningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyOwnTheme(true) {
                Scaffold(
                    topBar = {
                        TopAppBar (
                            title = { Text("Simple TopAppBar") },
                            navigationIcon = {
                                IconButton(onClick = { /* doSomething() */ }) {
                                    Icon(Icons.Filled.Menu, contentDescription = null)
                                }
                            },
                            actions = {
                                // RowScope here, so these icons will be placed horizontally
                                IconButton(onClick = { /* doSomething() */ }) {
                                    Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
                                }
                                IconButton(onClick = { /* doSomething() */ }) {
                                    Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
                                }
                            }
                                )
                    }
                ) {
                    // Screen content
                    // A surface container using the 'background' color from the theme
                    Column(
                        // modifier = Modifier.fillMaxSize(),
                        //color = MaterialTheme.colors.background
                    ) {
                        CardDemo("What a superduper card!")
                        CardDemo("This one is kinda my card")

                        Row (
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier.fillMaxSize()
                        ){
                            FloatingActionButton(onClick = { /*TODO*/ }, Modifier.padding(5.dp)) {
                                Text("FAB")
                            }
                            FloatingActionButton(onClick = { /*TODO*/ }, Modifier.padding(5.dp)) {
                                Icon(Icons.Filled.Favorite, "")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardDemo(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text (
                text = title,
                color = MaterialTheme.colors.primaryVariant,
                style = MaterialTheme.typography.h4
                    )
            Text(
                buildAnnotatedString {
                    append("welcome to ")
                    withStyle(style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        color = MaterialTheme.colors.secondary
                    )
                    ) {
                        append("Jetpack Compose Playground")
                    }
                }
            )
            Text(
                buildAnnotatedString {
                    append("Now you are in the ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                        append("Card")
                    }
                    append(" section")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Do something! */ },
                shape = MaterialTheme.shapes.small.copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize,
                    topEnd = ZeroCornerSize,
                    topStart = CornerSize(16.dp)
                )
                 ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Like")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardDemo() {
    MymorningTheme {
        CardDemo("What a superduper card!")
    }
}