import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinjetpackcompose.ui.component.categoryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    viewModel: ProductViewModel = hiltViewModel(),
    onBackPress: () -> Unit
) {
    val categories by viewModel.categorys.collectAsState()

    // Chỉ gọi API một lần khi màn hình hiển thị
    LaunchedEffect(Unit) {
        if (categories.isEmpty()) {
            viewModel.fetchCategorys()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Danh mục") },
                navigationIcon = {
                    IconButton(onClick = { onBackPress }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (categories.isEmpty()) {
            // Hiển thị loading nếu danh sách rỗng
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            // Hiển thị danh sách danh mục
            LazyColumn(contentPadding = paddingValues) {
                items(categories) { category ->
                    categoryItem(imageRes = category.image_url, name = category.name)
                }
            }
        }
    }
}
