package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home

import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie.MovieFragment
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow.TvShowFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }

}