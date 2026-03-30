package com.aulasandroid.jogorespostas.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aulasandroid.jogorespostas.component.Logo

@Composable
fun Resultado(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()){
    Column(modifier = Modifier.fillMaxSize()) {
        Logo(modifier = Modifier)

        Card() {
            Text(
                text = "Bom Trabalho!!!"
            )
        }
            Text(text = "Voce acertou $pontos de 3")

        Button(
            onClick = {navController.navigate("login")},
            modifier = Modifier.height(40.dp)
                .width(200.dp),
        ){
            Text(text = "Jogar Novamente")
        }
    }
    }
}