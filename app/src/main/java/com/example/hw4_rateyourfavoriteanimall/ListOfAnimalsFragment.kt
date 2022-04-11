package com.example.hw4_rateyourfavoriteanimall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListOfAnimalsFragment : Fragment() {


//    private val FILE_NAME = "ratings"
//    var position = 0
//    private var animalList = listOf("Dog", "Cat", "Bear", "Rabbit")
//    var selected = ""


    lateinit var viewModel: ListOfAnimalsFragmentViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_of_animals_fragment, container, false)
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.NewInstanceFactory()
        )[ListOfAnimalsFragmentViewModel::class.java]

        var animalsAdapter: AnimalsAdapter? = null
        val animalsList: ArrayList<Animal> = ArrayList()

        animalsList.add(Animal("Dog", R.drawable.dog))
        animalsList.add(Animal("Cat", R.drawable.cat))
        animalsList.add(Animal("Bear", R.drawable.bear))
        animalsList.add(Animal("Rabbit", R.drawable.rabbit))

        recyclerView = view.findViewById(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.setLayoutManager(layoutManager)
        animalsAdapter = AnimalsAdapter(animalsList, requireActivity())
        recyclerView.setAdapter(animalsAdapter)

        return view

    }
}