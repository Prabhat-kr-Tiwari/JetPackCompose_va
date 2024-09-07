package com.prabhat.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prabhat.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioTheme {

                    Portfolio()

            }
        }
    }
}

@Composable
fun Portfolio() {

    var isOpen = remember {
        mutableStateOf(false)
    }
    Surface(shadowElevation = 8.dp, shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
        

        Column (modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally){

            Image(painter = painterResource(id = R.drawable.profile), contentDescription = null, modifier = Modifier.size(80.dp))

            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Prabhat Kumar Tiwari", style = TextStyle(color = Color.Green, fontSize = 20.sp,fontWeight = FontWeight.Bold ))
            Text(text = "Android compose Developer", style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Image(painter = painterResource(id = R.drawable.instagram), contentDescription = null, modifier = Modifier.size(18.dp))

                Text(text = "prabhat", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(horizontal = 8.dp))
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Image(painter = painterResource(id = R.drawable.github), contentDescription = null, modifier = Modifier.size(18.dp))
                Text(text = "prabhat-kr-tiwari", style = MaterialTheme.typography.titleSmall ,modifier = Modifier.padding(horizontal = 8.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { isOpen.value=!isOpen.value }) {
                Text(text = "MY Projects")
            }
            if (isOpen.value) {
                LazyColumn {
                    items(getProjectList()){
                        ProjectItem(it)

                    }

                }
            }

        }

    }

}

@Composable
fun ProjectItem(project: Project) {

    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Image(painter = painterResource(id = R.drawable.profile),
            contentDescription = null, modifier = Modifier
                .size(60.dp)
                .clip(CircleShape))
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = project.name,style=MaterialTheme.typography.headlineLarge)
            Text(text = project.desc,style=MaterialTheme.typography.bodySmall)
        }

    }


}

fun getProjectList():List<Project>{
    return  listOf(
        Project(name = "Campus connect", desc = "connect the students"),
        Project(name = "Campus connect", desc = "connect the students"),
        Project(name = "Campus connect", desc = "connect the students"),
        Project(name = "Campus connect", desc = "connect the students"),
                Project(name = "Campus connect", desc = "connect the students"),
    Project(name = "Campus connect", desc = "connect the students"),
    Project(name = "Campus connect", desc = "connect the students"),
    Project(name = "Campus connect", desc = "connect the students"),
            Project(name = "Campus connect", desc = "connect the students"),
    Project(name = "Campus connect", desc = "connect the students"),
    Project(name = "Campus connect", desc = "connect the students"),
    Project(name = "Campus connect", desc = "connect the students")


    )
}
data class Project(val name:String,val desc:String)
