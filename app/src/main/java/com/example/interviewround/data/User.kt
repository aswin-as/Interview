package com.example.interviewround.data


data class CommentResponse(
    val comments: List<Comment>
)
data class Comment(
    val body: String,
    val user: User
)

data class User(
    val username: String,
    val fullName: String
)

