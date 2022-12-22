package com.example.marsrover.view.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.marsrover.MAIN
import com.example.marsrover.R
import com.example.marsrover.model.Photo
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainFragmentTest : TestCase() {

    private lateinit var scenario: FragmentScenario<MainFragment>


    @Before
    fun setup(){
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_MarsRover)
        scenario.moveToState(Lifecycle.State.STARTED)
    }


}