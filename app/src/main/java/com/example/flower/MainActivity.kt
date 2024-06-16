package com.example.flower

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flower.ui.theme.FlowerTheme
import com.example.flower.ui.theme.md_theme_dark_background
import com.example.flower.ui.theme.shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowerTheme {
                Manager(Modifier.background(MaterialTheme.colorScheme.secondary))
            }
        }
    }
}
@Composable
fun Manager(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(1) }

    Surface(modifier) {
        if (shouldShowOnboarding == 1) {
            FlowerApp(
                onButton1Clicked = { shouldShowOnboarding = 2 },
                onButton2Clicked = { shouldShowOnboarding = 3 },
                onButton3Clicked = { shouldShowOnboarding = 4 },
                onButton4Clicked = { shouldShowOnboarding = 5 }
            )
        } else if (shouldShowOnboarding == 2) {
            AsterDetails(onBackClicked = { shouldShowOnboarding = 1 })
        } else if (shouldShowOnboarding == 3) {
            BloomDetails(onBackClicked = { shouldShowOnboarding = 1 })
        } else if (shouldShowOnboarding == 4) {
            BlossomDetails(onBackClicked = { shouldShowOnboarding = 1 })
        } else {
            TulipDetails(onBackClicked = { shouldShowOnboarding = 1 })
        }
    }
}
@Composable
fun FlowerApp(
    modifier: Modifier = Modifier,
    onButton1Clicked: () -> Unit,
    onButton2Clicked: () -> Unit,
    onButton3Clicked: () -> Unit,
    onButton4Clicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxHeight()
    ){
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Surface(
                    onClick = onButton1Clicked,
                    modifier = modifier
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.aster),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(190.dp)
                            .clip(shapes.large)
                    )
                }
                Text(
                    text = "Aster",
                    fontSize = 40.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    onClick = onButton2Clicked,
                    modifier = modifier
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bloom),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(190.dp)
                            .clip(shapes.large)
                    )
                }
                Text(
                    text = "Bloom",
                    fontSize = 40.sp,
                )
            }
        }
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Surface(
                    onClick = onButton3Clicked,
                    modifier = modifier
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.blossom),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(190.dp)
                            .clip(shapes.large)
                    )
                }
                Text(
                    text = "Blossom",
                    fontSize = 40.sp,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    onClick = onButton4Clicked,
                    modifier = modifier
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tulip),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(190.dp)
                            .clip(shapes.large)
                    )
                }
                Text(
                    text = "Tulip",
                    fontSize = 40.sp,
                )
            }
        }
    }
}
@Composable
fun AsterDetails(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    ) {
    val text  = listOf("Aster", "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster")
    Column (
        modifier = modifier
            .padding(top = 20.dp)
    ) {
        Surface(
            onClick = onBackClicked
        ) {
            Row {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
        Row {
            LazyColumn(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(Aster) { text ->
                    Image(
                        painter = painterResource(id = text),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(shapes.small)
                            .size(height = 200.dp, width = 1080.dp)
                    )
                }
                items(text) { text ->
                    Text(text = text, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}
@Composable
fun BloomDetails(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    ) {
    val text  = listOf("Aster", "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster")
    Column (
        modifier = modifier
            .padding(top = 20.dp)
    ) {
        Surface(
            onClick = onBackClicked
        ) {
            Row {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
        Row {
            LazyColumn(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(Bloom) { text ->
                    Image(
                        painter = painterResource(id = text),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(shapes.small)
                            .size(height = 200.dp, width = 1080.dp)
                    )
                }
                items(text) { text ->
                    Text(text = text, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}
@Composable
fun BlossomDetails(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
) {
    val text  = listOf("Aster", "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster")
    Column (
        modifier = modifier
            .padding(top = 20.dp)
    ){
        Surface(
            onClick = onBackClicked
        ) {
            Row {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
        Row {
            LazyColumn(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(Blossom) { text ->
                    Image(
                        painter = painterResource(id = text),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(shapes.small)
                            .size(height = 200.dp, width = 1080.dp)
                    )
                }
                items(text) { text ->
                    Text(text = text, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}
@Composable
fun TulipDetails(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
) {
    val text  = listOf("Aster", "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster"
        , "Aster", "Aster", "Aster", "Aster", "Aster")
    Column (
        modifier = modifier
            .padding(top = 20.dp)
    ){
        Surface(
            onClick = onBackClicked
        ) {
            Row {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
        Row {
            LazyColumn(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(Tulip) { text ->
                    Image(
                        painter = painterResource(id = text),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(shapes.small)
                            .size(height = 200.dp, width = 1080.dp)
                    )
                }
                items(text) { text ->
                    Text(text = text, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}
private val Aster = listOf(R.drawable.aster)
private val Bloom = listOf(R.drawable.bloom)
private val Blossom = listOf(R.drawable.blossom)
private val Tulip = listOf(R.drawable.tulip)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun FlowerAppPreview() {
    FlowerTheme {
        FlowerApp(modifier = Modifier.fillMaxSize(),{},{},{},{})
    }
}
@Preview(showBackground = true)
@Composable
fun AsterDetailsPreview() {
    FlowerTheme {
        AsterDetails(modifier = Modifier.fillMaxSize(),{})
    }
}
@Preview(showBackground = true)
@Composable
fun BloomDetailsPreview() {
    FlowerTheme {
        BloomDetails(modifier = Modifier.fillMaxSize(),{})
    }
}
@Preview(showBackground = true)
@Composable
fun BlossomDetailsPreview() {
    FlowerTheme {
        BlossomDetails(modifier = Modifier.fillMaxSize(),{})
    }
}
@Preview(showBackground = true)
@Composable
fun TulipDetailsPreview() {
    FlowerTheme {
        TulipDetails(modifier = Modifier.fillMaxSize(),{})
    }
}