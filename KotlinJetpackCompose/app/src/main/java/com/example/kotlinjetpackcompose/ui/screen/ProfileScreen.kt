package com.example.kotlinjetpackcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Header màu cam với avatar và nút đăng nhập
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color(0xFFE65100)) // Màu cam
        ) {
            Box( // Box con để dùng align()
                modifier = Modifier.fillMaxSize()
            ) {
                // Avatar nằm góc dưới trái
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.BottomStart) // Đặt icon ở góc dưới trái
                        .padding(start = 16.dp, bottom = 16.dp), // Thêm padding để không sát mép
                    tint = Color.White
                )

                // Button nằm góc dưới phải
                Button(
                    onClick = { /* TODO: Xử lý đăng nhập */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .align(Alignment.BottomEnd) // Đặt button ở góc dưới phải
                        .padding(end = 16.dp, bottom = 30.dp) // Thêm padding để không sát mép
                ) {
                    Text("Đăng nhập / Đăng ký", color = Color(0xFFE65100))
                }
            }
        }


        // Danh sách các mục cài đặt
        val menuItems = listOf(
//            Pair(Icons.Outlined.ConfirmationNumber, "Ví Voucher"),
//            Pair(Icons.Outlined.Payment, "Thanh toán"),
            Pair(Icons.Outlined.LocationOn, "Địa chỉ"),
            Pair(Icons.Outlined.MailOutline, "Mời bạn bè"),
//            Pair(Icons.Outlined.HelpOutline, "Trung tâm Trợ giúp"),
//            Pair(Icons.Outlined.Storefront, "Ứng dụng cho chủ quán"),
//            Pair(Icons.Outlined.Description, "Chính sách quy định"),
            Pair(Icons.Outlined.Settings, "Cài đặt"),
//            Pair(Icons.Outlined.RestaurantMenu, "Về ShopeeFood")
        )

        LazyColumn {
            items(menuItems.size) { index ->
                val (icon, title) = menuItems[index] // ✅ Lấy phần tử chính xác từ danh sách
                MenuItem(icon, title)
            }
        }
    }
}

@Composable
fun MenuItem(icon: ImageVector, title: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .clickable { /* TODO: Xử lý click */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = title, tint = Color(0xFFE65100))
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "Next", tint = Color.Gray)
    }
}
