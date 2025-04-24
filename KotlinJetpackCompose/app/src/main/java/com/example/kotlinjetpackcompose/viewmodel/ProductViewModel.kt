import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinjetpackcompose.data.model.Category
import com.example.kotlinjetpackcompose.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _categorys = MutableStateFlow<List<Category>>(emptyList())
    val     categorys : StateFlow<List<Category>> = _categorys

    fun fetchCategorys(){
        viewModelScope.launch {
            val response = repository.getCategories()
            if(response.isSuccessful){
                _categorys.value = response.body() ?:  emptyList()
            }
        }
    }

}
