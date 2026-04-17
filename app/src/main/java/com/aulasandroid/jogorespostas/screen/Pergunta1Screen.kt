package com.aulasandroid.jogorespostas.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.jogorespostas.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Variável global (Cuidado: em apps Reais usamos ViewModel, mas manterei aqui como você fez)
var pontos = 0

@Composable
fun telaPergunta1(navController: NavController) {

    class Pergunta(
        val enunciado: String,
        val alternativas: List<String>,
        val alternativaCorreta: String,
    )

    val listaPerguntas = remember {
        listOf(
            Pergunta("qual o melhor tipo de menina?", listOf("feminista", "cacheada", "loira", "morena"), "cacheada"),
            Pergunta("Qual numero é maior ?", listOf("10", "7", "8", "100"), "8"),
            Pergunta("Qual o melhor professor ?", listOf("newton", "leo", "jade", "tudo ruim"), "newton"),
            Pergunta("qual o melhor mascote (sem roubo 🙈)?", listOf("batman", "arara", "pinguim", "dog dog"), "dog dog"),
            Pergunta("Quem arrasto o japones ?", listOf("vitor", "breno", "igor", "todos"), "igor"),
            Pergunta("Quem rouba mais no truco ?", listOf("vitor", "sales", "igor", "todos"), "todos"),
            Pergunta("como é o cabelo da menina mais gata da escola (segundo kauan 😜👍) ?", listOf("castanho", "cacheada", "loira", "todas"), "castanho"),
            Pergunta("Qual o melhor jogador?", listOf("mr. bombinha", "breno", "bahia", "tudo fudido"), "tudo fudido")
        )
    }

    // ESTADOS
    var indiceAtual by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    var opcaoSelecionada by remember { mutableStateOf<String?>(null) }
    var travado by remember { mutableStateOf(false) }

    // Dados da pergunta atual
    val perguntaAtual = listaPerguntas[indiceAtual]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.cor_app))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "logo",
            modifier = Modifier.size(100.dp).padding(vertical = 20.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF90D5A1)),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Text(
                text = "Pergunta ${indiceAtual + 1} de ${listaPerguntas.size}",
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 12.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = perguntaAtual.enunciado,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                perguntaAtual.alternativas.forEach { opcao ->

                    // LÓGICA DE CORES
                    val corBotao = when {
                        opcaoSelecionada == null -> Color.Transparent
                        opcao == perguntaAtual.alternativaCorreta -> Color.Green.copy(alpha = 0.5f)
                        opcao == opcaoSelecionada -> Color.Red.copy(alpha = 0.5f)
                        else -> Color.Transparent
                    }

                    OutlinedButton(
                        onClick = {
                            if (!travado) {
                                travado = true
                                opcaoSelecionada = opcao

                                scope.launch {
                                    if (opcao == perguntaAtual.alternativaCorreta) {
                                        pontos++
                                    }

                                    delay(800) // Pausa para ver a cor mudar

                                    if (indiceAtual < listaPerguntas.size - 1) {
                                        indiceAtual++
                                        // Reset para a próxima
                                        opcaoSelecionada = null
                                        travado = false
                                    } else {
                                        navController.navigate("Resultado")
                                        // Reset para caso o usuário volte ao jogo
                                        indiceAtual = 0
                                        opcaoSelecionada = null
                                        travado = false
                                    }
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).height(56.dp),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color.LightGray),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = corBotao)
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