package com.example.test_app.utils

sealed class Resource<T>(val data: T?=null,message: String?=null){
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String,data: T?=null): Resource<T>(data,message)

}
