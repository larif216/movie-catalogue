package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie

import academy.bangkit.muhamadlutfiarif.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.core.ui.adapter.MovieClickListener
import academy.bangkit.muhamadlutfiarif.core.ui.adapter.MovieListAdapter
import academy.bangkit.muhamadlutfiarif.core.ui.viewmodel.ViewModelFactory
import academy.bangkit.muhamadlutfiarif.core.utils.vo.Status
import academy.bangkit.muhamadlutfiarif.moviecatalogue.MyApplication
import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentMovieBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.detail.DetailActivity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import javax.inject.Inject

class MovieFragment : Fragment(), MovieClickListener {

    private lateinit var binding: FragmentMovieBinding

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: MovieViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

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

            viewModel.getMovies().observe(viewLifecycleOwner, {
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