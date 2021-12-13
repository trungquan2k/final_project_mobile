package com.example.jetsellbook.data


import com.example.jetsellbook.model.BooksModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL="https://booksale-api.herokuapp.com/api/"

interface ApiService{
    @GET("book-api")
    suspend fun  getBooks():List<BooksModel>
    companion object{
        var apiService: ApiService ?=null
        fun getInstansce(): ApiService{
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

}

