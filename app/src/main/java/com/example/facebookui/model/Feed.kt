package com.example.facebookui.model

data class Feed(
    val isHeader: Boolean = false,
    val post: Post? = null,
    val stories: ArrayList<Story> = ArrayList()
)
