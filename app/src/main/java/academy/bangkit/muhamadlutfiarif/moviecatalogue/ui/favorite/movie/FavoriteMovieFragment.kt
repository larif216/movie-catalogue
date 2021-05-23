package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentMovieBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.DetailActivity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.MovieClickListener
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.MovieListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie.MovieViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.viewmodel.ViewModelFactory
import academy.bangkit.muhamadlutfiarif.moviecatalogue.vo.Status
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class FavoriteMovieFragment : Fragment(), MovieClickListener {
    private lateinit var binding: FragmentFavoriteMovieBinding
    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            viewModel.getFavoriteMovies().observe(this, {
                if (it != null) {
                    val movieListAdapter = MovieListAdapter(this)
                    movieListAdapter.submitList(it)
                    movieListAdapter.notifyDataSetChanged()

                    with(binding.rvMovies) {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = movieListAdapter
                    }
                }
            })
        }
    }

    override fun onItemClicked(catalogue: MovieEntity?) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", catalogue?.id)
        intent.putExtra("type", 0)
        startActivity(intent)
    }
}