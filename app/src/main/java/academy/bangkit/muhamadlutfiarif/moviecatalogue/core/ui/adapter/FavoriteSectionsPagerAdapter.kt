package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.adapter

import academy.bangkit.muhamadlutfiarif.moviecatalogue.favorite.movie.FavoriteMovieFragment
import academy.bangkit.muhamadlutfiarif.moviecatalogue.favorite.tvshow.FavoriteTvShowFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FavoriteSectionsPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavoriteMovieFragment()
            1 -> fragment = FavoriteTvShowFragment()
        }
        return fragment as Fragment
    }

}