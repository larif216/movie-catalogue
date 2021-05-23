package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.DetailActivity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.MovieListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.TvShowClickListener
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.TvShowListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie.MovieViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow.TvShowViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.viewmodel.ViewModelFactory
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class FavoriteTvShowFragment : Fragment(), TvShowClickListener {
    private lateinit var binding: FragmentFavoriteTvShowBinding
    private lateinit var viewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            viewModel.getFavoriteTvShows().observe(this, {
                if (it != null) {
                    val tvShowListAdapter = TvShowListAdapter(it, this)
                    tvShowListAdapter.notifyDataSetChanged()

                    with(binding.rvTvShows) {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = tvShowListAdapter
                    }
                }
            })
        }
    }

    override fun onItemClicked(catalogue: TvShowEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", catalogue.id)
        intent.putExtra("type", 1)
        startActivity(intent)
    }
}