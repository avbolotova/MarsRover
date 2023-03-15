package com.example.marsrover

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.marsrover.view.main.MainAdapter
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainActivityTest {

    @Before
    fun launchActivity() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Ignore("Need to find solution for CollapsingToolbarLayout with NestedScrollView")
    @Test
    fun shouldBeSelectedColorWhenClickOnItem() {
        val firstItem = 0
        Espresso.onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MainAdapter.MyViewHolder>(
                firstItem,
                clickOnViewChild(R.id.eachImage)
            )
        )
        Espresso.onView(withId(R.id.favoritePhoto)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.pressBack()

    }

    private fun clickOnViewChild(viewId: Int) = object : ViewAction {
        override fun getConstraints() = null
        override fun getDescription() = "Click on a child view with specified id."
        override fun perform(uiController: UiController, view: View) =
            ViewActions.click().perform(uiController, view.findViewById<View>(viewId))
    }
}
