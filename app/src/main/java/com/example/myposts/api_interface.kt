package com.example.myposts



import ...



interface api_interface {
    @GET("posts")
    fun getPosts(): Call<List<Posts>>
}