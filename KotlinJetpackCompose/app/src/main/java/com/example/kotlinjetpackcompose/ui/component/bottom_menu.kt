package menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Bottom_menu() {
    val selectedIndex = remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFE4C7)) // Cùng màu với background tổng thể
    ) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Đảm bảo nó nằm dưới
                .background(Color.White),
            tonalElevation = 4.dp
        ) {
            val items = listOf("Home", "Favorites", "Cart", "Account")
            val icons = listOf(
                Icons.Outlined.Home,
                Icons.Default.FavoriteBorder,
                Icons.Outlined.ShoppingCart,
                Icons.Outlined.AccountCircle
            )

            items.forEachIndexed { index, label ->
                //index là 0 1 2 3
                //label là home favo cart acc
                NavigationBarItem(
                    icon = {
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Icon(
                                imageVector = icons[index],
                                contentDescription = label
                            )
                            if(selectedIndex.value == index){
                                Text(
                                    text = label,
                                    modifier = Modifier.padding(start = 4.dp),
                                    color = Color.White
                                )

                            }
                        }
                    },
                    selected = selectedIndex.value == index,
                    onClick = {selectedIndex.value = index},
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = if (selectedIndex.value == index) Color(0xFFFD4D4D) else Color.Transparent,
                        selectedIconColor = Color.White
                    )

                )
            }

        }
    }
}
