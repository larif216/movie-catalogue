package academy.bangkit.muhamadlutfiarif.favorite.movie

import academy.bangkit.muhamadlutfiarif.core.di.DaggerCoreComponent
import academy.bangkit.muhamadlutfiarif.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.core.ui.adapter.MovieClickListener
import academy.bangkit.muhamadlutfiarif.core.ui.adapter.MovieListAdapter
import academy.bangkit.muhamadlutfiarif.core.ui.viewmodel.ViewModelFactory
import academy.bangkit.muhamadlutfiarif.favorite.databinding.FragmentFavoriteMovieBinding
import academy.bangkit.muhamadlutfiarif.favorite.di.DaggerFavoriteComponent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.detail.DetailActivity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import javax.inject.Inject

class FavoriteMovieFragment : Fragment(), MovieClickListener {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var binding: FragmentFavoriteMovieBinding

    private val viewModel: FavoriteMovieViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteComponent
            .factory()
            .create(DaggerCoreComponent.factory().create(context))
            .inject(this)
    }

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
            val movieListAdapter = MovieListAdapter(this)

            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, {
                if (it != null) {
                    movieListAdapter.setData(it)

                    with(binding.rvMovies) {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = movieListAdapter
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