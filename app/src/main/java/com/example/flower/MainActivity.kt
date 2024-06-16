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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flower.ui.theme.FlowerTheme
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
    var shouldShowOnboarding by rememberSaveable { mutableIntStateOf(1) }

    Surface(modifier) {
        when (shouldShowOnboarding) {
            1 -> {
                FlowerApp(
                    onButton1Clicked = { shouldShowOnboarding = 2 },
                    onButton2Clicked = { shouldShowOnboarding = 3 },
                    onButton3Clicked = { shouldShowOnboarding = 4 },
                    onButton4Clicked = { shouldShowOnboarding = 5 }
                )
            }
            2 -> {
                AsterDetails(onBackClicked = { shouldShowOnboarding = 1 })
            }
            3 -> {
                DahliaDetails(onBackClicked = { shouldShowOnboarding = 1 })
            }
            4 -> {
                BlossomDetails(onBackClicked = { shouldShowOnboarding = 1 })
            }
            else -> {
                TulipDetails(onBackClicked = { shouldShowOnboarding = 1 })
            }
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
                    text = "Dahlia",
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
    val text  = listOf("    The aster flower itself has a round center (typically yellow) surrounded by clusters of narrow petals. It is named for its star-like appearance of ray-like petals emanating from a central area (Aster means 'star' in Greek). Asters grow on a woody stem or stalk, which gives the taller bushes the extra support they need.",
        "   There are roughly 180 different species of true aster. There used to be a lot more, but they have been removed and reclassified throughout the plant world. Most true asters (minus one) are native to Eurasia. Even though most of the flowers in the family Asteraceae that are native to North America are not technically classified as asters anymore, they are still grouped together due to how they look (morphology) and how they are commonly known. Most people know them by the common name aster, and most florists still consider these wildflowers to be asters. In North America, there is one true aster, Aster alpinus or the alpine aster. All the rest have been reclassified into other genera.\n" +
                "\n" +
                "There are many genera of flowers that grow in North America. They include:\n" +
                "\n" +
                "->New England, Symphyotrichum novae-angliae\n" +
                "->New York, Symphyotrichum novi-belgii\n" +
                "->Aromatic, Symphyotrichum oblongifolium\n" +
                "->Heath, Symphyotrichum ericoides\n" +
                "->Smooth, Symphyotrichum leave\n" +
                "->Calico, Symphyotrichum lateriflorum")
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
                    Text(
                        text = text,
                        modifier = Modifier
                            .padding(8.dp),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
                }
            }
        }
    }
}
@Composable
fun DahliaDetails(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    ) {
    val text  = listOf("he national flower of Mexico, the dahlia, has a proud history reaching back to the days of the Aztec empire.\n" +
            "\n" +
            "Originally grown by the Aztecs as a food crop for their starchy root tubers, the dahlia was later transported back to Europe by Spanish colonists in the 18th century.\n" +
            "\n" +
            "Today, dahlias are an incredibly popular ornamental plant. While there are only 42 species, there are over 57,000 different cultivated varieties registered with the Royal Horticultural SocietyThe dahlia’s name in Nahuatl, the language spoken by the Aztec people, is acocoxochitl, meaning ‘water pipe flower’, as they used hollow Dahlia imperialis stems to transport water.Dahlias are perennial plants with a range of features across 42 species. Some have green herby stems, others have woody stems. The flowers are incredibly diverse, with colours including white, yellow, orange, red and purple of varying shades. Dahlia flower structure also varies considerably, including simple star arrangements, complex spherical balls and flowers resembling waterlily blooms. Dahlias grow from underground tubers, which can be split to create new dahlia plants.")
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
                    Text(
                        text = text,
                        modifier = Modifier
                            .padding(8.dp),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    )
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
    val text  = listOf("A blossom is a flower that grows on stone fruit trees and other plants including oranges, cherries, plums, apples and almonds and of some other plants with a similar appearance that flower profusely for a period of time in spring.\n" +
            "\n" +
            "Colloquially flowers of orange are referred to as such as well. Peach blossoms (including nectarine), most cherry blossoms, and some almond blossoms are usually pink. Plum blossoms, apple blossoms, orange blossoms, some cherry blossoms, and most almond blossoms are white.\n" +
            "\n" +
            "Blossoms provide pollen to pollinators such as bees, and initiate cross-pollination necessary for the trees to reproduce by producing fruit.\n" +
            "\n" +
            "Blossom trees have a tendency to lose their flower petals in wind-blown cascades, often covering the surrounding ground in petals. This attribute tends to distinguish blossom trees from other flowering trees.The ancient Phoenicians used almond blossoms with honey and urine as a tonic, and sprinkled them into stews and gruels to give muscular strength. Crushed petals were also used as a poultice on skin spots and mixed with banana oil, for dry skin and sunburn.\n" +
            "\n" +
            "In the ancient herbals the crab apple was used as treatment for boils, abscesses, splinters, wounds, coughs, colds and a host of other ailments ranging from acne to kidney ailments. Many dishes made with apples and apple blossom are of medieval origin. In the spring, monks and physicians would gather the blossoms and preserve them in vinegar for drawing poultices and for bee stings and other insect bites.")
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
                    Text(
                        text = text,
                        modifier = Modifier
                            .padding(8.dp)
                        ,fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    )
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
    val text  = listOf("The tulip is a member of the lily family which flowers in the spring and is a bulbous herb. About eighty species of tulips exist. The tulip gained popularity quickly after it was introduced in western Europe in the Sixteenth century. Tulip bulbs are still a major export of the Netherlands. Michigan and Washington are the most common states for growing tulips commercially in the United States.Tulips are erect flowers with long, broad, parallel-veined leaves and a cup-shaped, single or double flower at the tip of the stem. Colors of the flowers can range anywhere from red to yellow to white. Some tulips are varicolored as a result of a viral disease carried and transferred to the plants by aphids.\n" +
            "\nIn northern climates, tulip bulbs are planted before the ground freezes, usually between September and December. In warmer climates, they are treated as annuals. Tulips can grow in climate zones 2-7. Tulips are usually planted twice as deep as their height and about three to four inches apart. Tulip bulbs can be planted in all types of soil as long as there is good drainage. Tulips need to be watered thoroughly, and may need to be covered with leaves or compost during periods of severe frost.\n" +
            "\n"+
            "Tulips can make a colorful addition to any flower bed or garden and are very easy to grow.\n" +
            "\n")
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
                    Text(
                        text = text,
                        modifier = Modifier
                            .padding(8.dp),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    )
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
        AsterDetails(modifier = Modifier.fillMaxSize()) {}
    }
}
@Preview(showBackground = true)
@Composable
fun DahliaDetailsPreview() {
    FlowerTheme {
        DahliaDetails(modifier = Modifier.fillMaxSize()) {}
    }
}
@Preview(showBackground = true)
@Composable
fun BlossomDetailsPreview() {
    FlowerTheme {
        BlossomDetails(modifier = Modifier.fillMaxSize()) {}
    }
}
@Preview(showBackground = true)
@Composable
fun TulipDetailsPreview() {
    FlowerTheme {
        TulipDetails(modifier = Modifier.fillMaxSize()) {}
    }
}