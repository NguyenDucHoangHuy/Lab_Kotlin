package com.example.kotlinjetpackcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.kotlinjetpackcompose.R
import menu.Bottom_menu

@Preview(showBackground = true)
@Composable
fun DashboardScreen() {
    Scaffold(
        bottomBar = { Bottom_menu() } // Đặt Bottom_menu làm thanh navigation dưới cùng
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFE4C7))
                .padding(innerPadding) // Tránh bị che mất nội dung
                .padding(16.dp)
        ) {
            HeaderSection()
            BannerSection()
            SearchBar()
        }
    }
}


@Composable
fun HeaderSection(){
    Row(
       modifier = Modifier.fillMaxWidth(),
       horizontalArrangement = Arrangement.SpaceBetween, //chiều chính
       verticalAlignment = Alignment.CenterVertically   //chiều phụ
    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Box(
                modifier = Modifier
                    .size(55.dp) // Kích thước tổng thể lớn hơn ảnh để chứa viền
                    .clip(CircleShape) // Cắt viền thành hình tròn
                    .border(2.dp, Color.Gray, CircleShape) // Viền tròn
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(55.dp) // Kích thước ảnh nhỏ hơn viền
                        .clip(CircleShape) // Cắt ảnh thành hình tròn
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text("Welcome", color = Color.DarkGray, fontSize = 13.sp)
                Text("Huy Nguyen", color = Color.DarkGray, fontSize = 16.sp)
            }
        }
        Icon(Icons.Outlined.Notifications, contentDescription = "Notifications")
    }
}

@Composable
fun BannerSection(){
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner",
            modifier = Modifier.fillMaxWidth()
        )

    }
}
@Composable
fun SearchBar(){
    var searchText by remember { mutableStateOf("") }
    Spacer(modifier = Modifier.height(25.dp))
    TextField(
        value = searchText,
        onValueChange = {searchText = it},
        leadingIcon = {Icon(Icons.Default.Search, contentDescription = "Search")},
        placeholder = {Text("What do you want eat today?")},
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )

    )
}