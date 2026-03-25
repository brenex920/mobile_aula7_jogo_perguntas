package com.aulasandroid.jogorespostas.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.jogorespostas.R

val opcoes = listOf("Vênus", "Júpiter", "Saturno", "marte")
val certo = listOf("marte")
var pontos = 0

fun respostaCorreta(opcoes: List<String>, certo: List<String>) {
    if (opcoes == certo) {
        pontos++
    } else {
        pontos
    }

}

@Composable
fun telaPergunta1() {
    var corCard by remember { mutableStateOf(Color.White) }
    var enunciado by remember {
        mutableStateOf("Pergunta 1 de 3")
    }
    var pergunta by remember {
        mutableStateOf("Qual o planeta conhecido como planeta vermelho?")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.cor_app))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "imc logo",
            modifier = Modifier
                .size(100.dp)
                .padding(vertical = 20.dp)

        )

        Spacer(modifier = Modifier.height(24.dp))


        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF90D5A1)),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Text(
                text = "Pergunta 1 de 3",
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 12.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(24.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Qual planeta é conhecido como planeta vermelho?",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                opcoes.map { opcao ->

                    OutlinedButton(
                        onClick = {
                            respostaCorreta(
                                listOf("Vênus", "Júpiter", "Saturno", "marte"),
                                listOf("marte")
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .height(56.dp),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color.LightGray)
                    ) {
                        Text(
                            text = opcao,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            color = Color.Black,
                            fontSize = 18.sp
                        )

                    }
                }
            }
        }
    }
}