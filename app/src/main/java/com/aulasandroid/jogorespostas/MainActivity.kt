package com.aulasandroid.jogorespostas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aulasandroid.jogorespostas.screen.Resultado
import com.aulasandroid.jogorespostas.screen.inicialScreen
import com.aulasandroid.jogorespostas.screen.telaPergunta1
import com.aulasandroid.jogorespostas.ui.theme.JogoRespostasTheme

// CORREÇÃO 1: Removido o (navController = NavController) do cabeçalhodd
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JogoRespostasTheme {

                // CORREÇÃO 2: Você precisa criar o controlador aqui dentro do setContent
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = "login") {
                            inicialScreen(navController)
                        }

                        composable(route = "Menu") {
                            telaPergunta1(navController)
                        }
                        composable (route = "Resultado") {
                            Resultado(navController)
                        }

                    }
                }
            }
        }
    }
}