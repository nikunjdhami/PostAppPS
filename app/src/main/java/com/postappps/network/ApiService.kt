package com.postappps.network

import com.postappps.models.Post
import retrofit2.http.GET

interface ApiService {

    @GET("POSTS")
    suspend fun getPost(): List<Post>


}