package com.example.kotlinjetpackcompose.data.network

import com.example.kotlinjetpackcompose.data.model.Category
import retrofit2.http.GET

interface ProductService {
    @GET("product/categorys")
    suspend fun getCategorys() : retrofit2.Response<List<Category>>
}