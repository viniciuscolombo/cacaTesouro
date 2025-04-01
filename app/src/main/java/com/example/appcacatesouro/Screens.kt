package com.example.appcacatesouro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("dica1") }) {
            Text("Iniciar Caça ao Tesouro")
        }
    }
}

@Composable
fun dicaScreen(navController: NavController, dicaNumero: Int, nextRoute: String) {
    val dicas = listOf(
        "O que tem um anel mas não tem dedo?",
        "Quanto mais se tira, maior ele fica. O que é?",
        "Qual é o fim de tudo?"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pista $dicaNumero:")
        Text(text = dicas[dicaNumero - 1])

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate(nextRoute) }) {
            Text("Próxima Pista")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar")
        }
    }
}

@Composable
fun TreasureScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Parabéns! Você encontrou o tesouro!")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("home") {
                popUpTo("home") { inclusive = true }
            }
        }) {
            Text("Voltar ao Início")
        }
    }
}