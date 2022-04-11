package com.example.hw4_rateyourfavoriteanimall

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListOfAnimalsFragmentViewModel : ViewModel() {

    val animalPosition = MutableLiveData<Int>()


    fun setAnimalPosition(position:Int){
        animalPosition.value = position
    }
    fun getAnimalPosition(): Int? {
        return animalPosition.value

    }
}
