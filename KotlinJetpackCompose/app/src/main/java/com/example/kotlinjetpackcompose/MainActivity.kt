package com.example.kotlinjetpackcompose

import CategoryScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinjetpackcompose.ui.screen.DashboardScreen
import com.example.kotlinjetpackcompose.ui.screen.FirstScreen
import com.example.kotlinjetpackcompose.ui.screen.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bật full-screen
        WindowCompat.setDecorFitsSystemWindows(window, false)

        enableEdgeToEdge()
        setContent {
            CategoryScreen(onBackPress = { } )
        }
    }
}
@Composable
fun mainApp(){
    val navController = rememberNavController()
    Scaffold(

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "firstScreen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("firstScreen") {
                FirstScreen(
                    openDashboardScreen = {
                        navController.navigate("dashboardScreen")
                   }
                )
            }
            composable("dashboardScreen"){
                DashboardScreen()
            }
            composable("loginScreen") {
                LoginScreen()
            }
        }
    }
}




