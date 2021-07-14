package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.adapter.MovieClickListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentMovieBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.detail.DetailActivity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.adapter.MovieListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.viewmodel.ViewModelFactory
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Status
import android.content.Intent
import android.widget.Toast
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
            val movieListAdapter = MovieListAdapter(this)

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            viewModel.getMovies().observe(this, {
                if (it != null) {
                    when (it.status) {
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            movieListAdapter.setData(it.data)

                            with(binding.rvMovies) {
                                layoutManager = LinearLayoutManager(context)
                                setHasFixedSize(true)
                                adapter = movieListAdapter
                            }
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, getString(R.string.something_wrong), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    override fun onItemClicked(catalogue: Movie?) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", catalogue?.id)
        intent.putExtra("type", 0)
        startActivity(intent)
    }
}