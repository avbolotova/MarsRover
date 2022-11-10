package com.example.marsrover.view.detailed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.marsrover.MAIN
import com.example.marsrover.R
import com.example.marsrover.databinding.FragmentDetailedBinding
import com.example.marsrover.model.Photo

class DetailedFragment : Fragment() {

    private var mBind: FragmentDetailedBinding? = null
    private val binding get() = mBind!!
    lateinit var currentPhoto: Photo
//    private var isAddPhoto = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBind = FragmentDetailedBinding.inflate(layoutInflater, container, false)
        currentPhoto = arguments?.getSerializable("getPhoto") as Photo
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailedViewModel::class.java)
        Glide.with(MAIN)
            .load(currentPhoto.img_src)
            .centerCrop()
            .into(binding.detImage)
        binding.detRover.text = currentPhoto.rover.name
        binding.DetEarthdate.text = currentPhoto.earth_date
        binding.DetCamera.text = currentPhoto.camera.name
        binding.DetlanDate.text = currentPhoto.rover.launch_date


//        binding.detAddFt.setOnClickListener {
//            isAddPhoto = if(!isAddPhoto) {
//                binding.detAddFt.setImageResource(R.drawable.ic_turned_in_not_24)
//                viewModel.insert(currentPhoto){
//                }
//                true
//            } else {
//                binding.detAddFt.setImageResource(R.drawable.ic_turned_in_24)
//                viewModel.delete(currentPhoto){
//                }
//                false
//            }
//        }
    }
}