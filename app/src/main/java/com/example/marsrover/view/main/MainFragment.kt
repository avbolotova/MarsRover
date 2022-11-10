package com.example.marsrover.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrover.MAIN
import com.example.marsrover.R
import com.example.marsrover.databinding.FragmentMainBinding
import com.example.marsrover.model.Photo

class MainFragment : Fragment() {

    private lateinit var mBind: FragmentMainBinding
    private val binding get() = mBind
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBind = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel.initDatabase()
        recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        viewModel.getPhotos()
        viewModel.myMovies.observe(viewLifecycleOwner, {
            adapter.setList(it.body()!!.photos)
        })
    }
    companion object {
        fun clickFilms(photo: Photo) {
            val bundle = Bundle()
            bundle.putSerializable("getPhoto", photo)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailedFragment, bundle)
        }
    }
}