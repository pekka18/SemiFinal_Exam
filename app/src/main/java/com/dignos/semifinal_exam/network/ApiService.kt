package com.dignos.semifinal_exam.network

import com.dignos.semifinal_exam.models.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("/tweet/dignos")
    fun getPostList(): Call<List<Post>>

    @GET("/tweet/dignos/{id}")
    fun getPostById(@Path("id") id: String): Call<Post>

    @POST("/tweet/dignos")
    fun createPost(@Body post: Post): Call<Post>
}