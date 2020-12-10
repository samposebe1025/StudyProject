package com.kapustini.studyproject.data.models

data class Movie(

    var movieID: Int,
    val name: String,
    val levelPG: Int,
    val banner: String,
    val bannerPreview: String,
    val rating: Int,
    val reviews: Int,
    val favorites: Boolean,
    val storyLine: String,
    val tag: String,
    val movieDuration:String,
    val actorsID:List<Int>
)
