package com.example.kotlinjetpackcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinjetpackcompose.R



@Composable
fun FirstScreen(openDashboardScreen : () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4C7))
    ){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_chef),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(300.dp)
                .offset(y = (-80).dp)
        )
        Spacer(modifier = Modifier.padding(1.dp))


        Image(
            painter = painterResource(id = R.drawable.delivery_logo),
            contentDescription = "Delivery",
            modifier = Modifier
                .size(270.dp)
                .offset(y = (-10).dp)
        )
    }
        //Vùng bottom
        Box(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 80.dp, topEnd = 80.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0x72E91E63), Color(0xFFFF4081))
                    )
                ),
            contentAlignment = Alignment.Center)
        {

            Button(
                onClick = {
                    openDashboardScreen()
                },
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Red
                ),

            ){
                Text("GO", fontSize = 15.sp,maxLines = 1)
            }
        }

    }
}
