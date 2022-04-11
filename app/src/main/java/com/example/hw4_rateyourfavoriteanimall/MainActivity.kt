package com.example.hw4_rateyourfavoriteanimall

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rotationChange(ListOfAnimalsFragment(), AnimalDetailsFragment())
    }


    fun rotationChange(fragmentInPortrait:Fragment,fragmentInLandScape: Fragment){
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){

            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer,fragmentInPortrait)
                .addToBackStack(null)
                .commit()
        }

        else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.ratingContainer,fragmentInLandScape)
                .addToBackStack(null)
                .commit()
        }
    }


}