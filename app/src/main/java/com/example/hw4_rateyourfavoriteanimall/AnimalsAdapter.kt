package com.example.hw4_rateyourfavoriteanimall

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class AnimalsAdapter
    (private val animalsList: ArrayList<Animal>?, private val mContext: Context,)
    : RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>(){
    private val FILE_NAME = "ratings"
    val sharedPreferences = mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater.inflate(R.layout.animal_item,parent,false)
        return AnimalViewHolder(view)
    }
    override fun getItemCount(): Int {
        return animalsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animalsList!![position]

        holder.setAnimalName(animal.name)
        holder.setAnimalImage(animal.animalImage)

        holder.animalRatingBar.rating = sharedPreferences?.getFloat(animal.name+"_rating",0f)!!
        holder.animalItemLayout.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("animalName",animal.name)
            bundle.putInt("animalImage",animal.animalImage)

            val fragmentInPortrait = AnimalDetailsFragment()
            val fragmentInLandscape = AnimalDetailsFragment()

            fragmentInPortrait.arguments = bundle
            (mContext as MainActivity).rotationChange(fragmentInPortrait,fragmentInLandscape)


        }
    }

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val animalImage = itemView.findViewById<ImageView>(R.id.animal_image)
        val animalName = itemView.findViewById<TextView>(R.id.animal_name)
        val animalRatingBar = itemView.findViewById<RatingBar>(R.id.animal_rating_bar)
        val animalItemLayout = itemView.findViewById<ConstraintLayout>(R.id.animal_item_card_view)
        fun setAnimalImage(animalImageResource: Int){
            animalImage.setImageResource(animalImageResource)
        }

        fun setAnimalName(animalName: String?){
            this.animalName.text = animalName
        }

        fun setAnimalRatingBar(animalRating: Float){
            this.animalRatingBar.rating = animalRating
        }


    }
}

