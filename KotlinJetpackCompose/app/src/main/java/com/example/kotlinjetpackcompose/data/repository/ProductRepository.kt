package com.example.kotlinjetpackcompose.data.repository

import com.example.kotlinjetpackcompose.data.model.Category
import com.example.kotlinjetpackcompose.data.network.ProductService
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService : ProductService
) {
    suspend fun getCategories() : retrofit2.Response<List<Category>>{
        return productService.getCategorys()
    }

}