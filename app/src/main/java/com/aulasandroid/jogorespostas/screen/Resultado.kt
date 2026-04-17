package com.aulasandroid.jogorespostas.screen

import android.R.attr.text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.jogorespostas.R
import com.aulasandroid.jogorespostas.component.Logo

@Composable
fun Resultado(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()){
    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Logo(modifier = Modifier,)

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Cyan),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

            ){
                Spacer(modifier = Modifier.height(20.dp))
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF90D5A1)),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    // USANDO A VARIÁVEL ENUNCIADO
                    Text(
                        text = "bom trabalho",
                        modifier = Modifier.padding(horizontal = 40.dp, vertical = 12.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "voce acertou $pontos de 8",
                    modifier = Modifier.height(50.dp),
                    fontSize = 30.sp
                )
            }


            }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                navController.navigate("login")
                      pontos = 0
                      },
            modifier = Modifier.height(40.dp)
                .width(200.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.cor_amarelo))

        ){
            Text(modifier = Modifier.padding(3.dp, 3.dp),
                text = "Jogar Novamente",
                color = Color.Black,

            )
        }
    }
    }
}


