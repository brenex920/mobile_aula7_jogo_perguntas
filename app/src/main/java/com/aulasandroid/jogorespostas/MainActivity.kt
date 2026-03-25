package com.aulasandroid.jogorespostas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.aulasandroid.jogorespostas.screen.inicialScreen
import com.aulasandroid.jogorespostas.screen.telaPergunta1
import com.aulasandroid.jogorespostas.ui.theme.JogoRespostasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JogoRespostasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   // inicialScreen()
                    telaPergunta1()
                }
            }
        }
    }
}

