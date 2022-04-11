package com.example.hw4_rateyourfavoriteanimall

import android.content.Context.MODE_PRIVATE
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RatingBar
import kotlinx.android.synthetic.main.animal_details_fragment.*
import kotlinx.android.synthetic.main.animal_details_fragment.view.*

class AnimalDetailsFragment : Fragment() {

    var animalName:String = ""
    var animalImage:Int = 0
//    private val animalList = listOf("Dog", "Cat", "Bear", "Rabbit")

//    lateinit var viewModel: FragmentOfAnimalAllViewModel
//    var position = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val inflate = inflater.inflate(R.layout.animal_details_fragment, container, false)


        animalName = requireArguments().getString("animalName").toString()
        animalImage = requireArguments().getInt("animalImage")

        inflate.animal_type.text = animalName

        inflate?.findViewById<ImageView>(R.id.animal_image)?.setImageResource(animalImage)
        inflate.save_button.setOnClickListener() {
            Toast.makeText(activity, "Rating: ${ratingBar.rating}", Toast.LENGTH_LONG).show()
            save(inflate)
        }
        return inflate;
    }

    fun save(view: View) {

        val myRatingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        val rating = myRatingBar.rating

        val sharedPreferences = requireActivity().getSharedPreferences("ratings", MODE_PRIVATE)
        val editor = sharedPreferences.edit()


        editor.putFloat(animalName+"_rating", rating)
        editor.apply()


        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, ListOfAnimalsFragment())
                .addToBackStack(null)
                .commit()
        } else {

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, ListOfAnimalsFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
