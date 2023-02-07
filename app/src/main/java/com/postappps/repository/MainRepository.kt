package com.postappps.repository

import com.postappps.models.Post
import com.postappps.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor( private val apiServiceImpl: ApiServiceImpl){

   suspend fun getPost() : Flow<List<Post>> = flow {
       emit(apiServiceImpl.getPosts())
   }.flowOn(Dispatchers.IO)
}