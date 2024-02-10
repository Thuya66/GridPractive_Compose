package com.thuya.gridpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thuya.gridpractice.data.DataSource
import com.thuya.gridpractice.model.Topic
import com.thuya.gridpractice.ui.theme.GridPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicCardApp(

                    )
                }
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card (
        modifier = modifier
            .fillMaxWidth()
            .height(68.dp)
    ){
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
            )
            Column (
                modifier = Modifier.padding(PaddingValues(16.dp, 16.dp, 16.dp, 2.dp))
            ){
                Text(
                    text = stringResource(id = topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(PaddingValues(0.dp, 0.dp, 0.dp, 8.dp))
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(painter = painterResource(R.drawable.ic_grain), contentDescription = null)
                    Text(
                        text = topic.numberRated.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(PaddingValues(8.dp, 0.dp, 0.dp, 0.dp))
                    )
                }
            }
        }
    }
}

@Composable
fun TopicList(topicsList : List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        content = {
            items(topicsList){
                topic -> TopicCard(topic = topic)
            }
        }
    )
}

@Composable
fun TopicCardApp() {
    TopicList(
        topicsList = DataSource.topics
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GridPracticeTheme {
        TopicCardApp()
    }
}