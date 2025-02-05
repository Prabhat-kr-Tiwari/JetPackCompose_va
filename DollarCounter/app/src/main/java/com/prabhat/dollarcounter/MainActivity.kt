package com.prabhat.dollarcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prabhat.dollarcounter.ui.theme.DollarCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DollarCounterTheme {
               MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        innerPadding
        DollarCounter()
    }

}

@Composable
fun DollarCounter() {

    val counter=remember {
        mutableIntStateOf(1)
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "$${counter.value*100}", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(180.dp))

        CustomButton {
            counter.value++
        }
        
    }
}

@Composable
fun CustomButton(onClick:()->Unit) {


    Card(modifier = Modifier
        .clickable {

            onClick.invoke()
        }
        .size(120.dp)
        , shape = CircleShape,colors = CardDefaults.cardColors(
            containerColor = Color.Yellow, //Card background color
            contentColor = Color.White  //Card content color,e.g.text
        )) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = "Tap", style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold))
        }
        
    }
    
    
}
