package com.postappps.network

import com.postappps.models.Post
import javax.inject.Inject

class ApiServiceImpl
 @Inject
 constructor( private val apiService: ApiService){
     suspend fun getPosts() = apiService.getPost()
}