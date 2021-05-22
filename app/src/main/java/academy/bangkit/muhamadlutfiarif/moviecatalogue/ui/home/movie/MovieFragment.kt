package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentMovieBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.activities.DetailActivity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.MovieClickListener
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.MovieListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.viewmodel.ViewModelFactory
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class MovieFragment : Fragment(), MovieClickListener {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            viewModel.getMovies().observe(this, {
                val movieListAdapter = MovieListAdapter(it, this)

                with(binding.rvMovies) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = movieListAdapter
                }
            })
        }
    }

    override fun onItemClicked(catalogue: MovieEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", catalogue.id)
        intent.putExtra("type", 0)
        startActivity(intent)
    }
}