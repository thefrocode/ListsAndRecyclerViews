package the.frocode.listandrecyclerviews

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import the.frocode.listandrecyclerviews.ui.theme.ListAndRecyclerViewsTheme


data class Person(
    val id: Int,
    val section: Int,
    val name: String,
    val imageUrl: String
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val persons = arrayListOf<Person>()
        var section = 1
        for(i in 1..200){
            persons.add(Person(i, section, "Person $i", "https://picsum.photos/200/300"))
            if(i % 10 == 0){
                section++
            }
        }
        setContent {
            ListAndRecyclerViewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumnClickableWithImageDemo(persons){
                        Toast.makeText(this, "Person ${it.name} clicked", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

@Composable
fun ScrollableColumnDemo(){

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)){
        for( i in 1..200){
            Text(text="Person $i", fontSize = 36.sp, modifier = Modifier.padding(8.dp))
            Divider(color = Color.Gray, thickness= 1.dp)
        }
    } 
}

@Composable
fun LazyColumnDemo(){

    LazyColumn(){
        items(200){
            Text(text="Person $it+1", fontSize = 36.sp, modifier = Modifier.padding(8.dp))
            Divider(color = Color.Gray, thickness= 1.dp)
        }
    }
}
@Composable
fun LazyColumnClickableDemo(selectedPerson: (Int)->Unit){

    LazyColumn(){
            items(200){
                Surface(modifier = Modifier.clickable { selectedPerson(it+1) }) {
                Text(text="Person ${it+1}", fontSize = 36.sp, modifier = Modifier.padding(8.dp))
                Divider(color = Color.Gray, thickness= 1.dp)
            }
        }

    }
}
@Composable
fun LazyColumnClickableWithImageDemo(persons: List<Person>,selectedPerson: (Person)->Unit){

    LazyColumn {
        items(items=persons, itemContent={
            ListItem(person = it, selectedPerson = selectedPerson)
        })
    }
}

@Composable
fun ImageLoader(imageUrl: String){
    Image(painter = rememberImagePainter(imageUrl), contentDescription = null,
        contentScale = ContentScale.Crop, modifier = Modifier.size(120.dp))
}

@Composable
fun ListItem(person: Person, selectedPerson: (Person) -> Unit){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { selectedPerson(person) },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row {
            ImageLoader(person.imageUrl)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = person.name, fontSize = 24.sp,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}