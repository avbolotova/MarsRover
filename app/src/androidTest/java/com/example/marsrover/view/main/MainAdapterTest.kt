package com.example.marsrover.view.main

import com.example.marsrover.model.Photo
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainAdapterTest {

    private var listPhotos = emptyList<Photo>()

    @Test
    fun setList(list: List<Photo>) {
        listPhotos = list
    }
}
