package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyMovies[0].title)))

        onView(withId(R.id.tv_detail_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_duration)).check(matches(withText(dummyMovies[0].duration)))

        onView(withId(R.id.tv_detail_user_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_user_score)).check(matches(withText(dummyMovies[0].userScore)))

        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyMovies[0].genre)))

        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyMovies[0].overview)))

        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyTvShows[0].title)))

        onView(withId(R.id.tv_detail_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_duration)).check(matches(withText(dummyTvShows[0].duration)))

        onView(withId(R.id.tv_detail_user_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_user_score)).check(matches(withText(dummyTvShows[0].userScore)))

        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyTvShows[0].genre)))

        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyTvShows[0].overview)))

        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
    }
}