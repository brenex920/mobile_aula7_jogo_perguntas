package com.aulasandroid.jogorespostas.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.jogorespostas.R

@Composable
fun inicialScreen(){
    Box(
        modifier = Modifier.fillMaxSize()
            .fillMaxHeight()
            .background(Color.Blue)
    ){
        //header
        Column(modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(color = colorResource(R.color.cor_app)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(175.dp))

            Image(
                painter = painterResource(R.drawable.quiz),
                contentDescription = "imc logo",
                modifier = Modifier
                    .size(180.dp)
                    .padding(vertical = 20.dp)

            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "QUIZATRON 3000",
                modifier = Modifier.height(50.dp),
                fontSize = 35.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {},
                modifier = Modifier.height(40.dp)
                    .width(200.dp),
            ) {Text(
                text = "COMECAR!",
                    ) }
        }
    }
}