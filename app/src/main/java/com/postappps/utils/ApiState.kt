package com.postappps.utils

import com.postappps.models.Post

sealed class ApiState{
    object Loading : ApiState()
    class Failure(val e : Throwable) : ApiState()
    class Success(val data : List<Post>) : ApiState()
    object Empty : ApiState()
}
