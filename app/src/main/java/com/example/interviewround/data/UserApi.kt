package com.example.interviewround.data

import retrofit2.http.GET

interface UserApi {
    @GET("comments")
    suspend fun getComments(): CommentResponse
}