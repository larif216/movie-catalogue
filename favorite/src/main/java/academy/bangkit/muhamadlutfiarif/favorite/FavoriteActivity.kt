package academy.bangkit.muhamadlutfiarif.favorite

import academy.bangkit.muhamadlutfiarif.favorite.databinding.ActivityFavoriteBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    companion object {
        private val TAB_TITLES = intArrayOf(
                R.string.tab_text_movies,
                R.string.tab_text_tv_shows
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
        supportActionBar?.title = getString(R.string.favorite_movie)
    }
}