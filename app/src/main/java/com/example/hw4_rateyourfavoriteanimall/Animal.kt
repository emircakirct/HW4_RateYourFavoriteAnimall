package com.example.hw4_rateyourfavoriteanimall

import android.widget.RatingBar

class Animal (var name:String, var animalImage: Int){
    var ratingBar: RatingBar? = null
    fun setImageResourceId(imageResourceId: Int){
        animalImage = imageResourceId
    }
}