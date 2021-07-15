package academy.bangkit.muhamadlutfiarif.favorite.tvshow

import academy.bangkit.muhamadlutfiarif.core.di.DaggerCoreComponent
import academy.bangkit.muhamadlutfiarif.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.core.ui.adapter.TvShowClickListener
import academy.bangkit.muhamadlutfiarif.core.ui.adapter.TvShowListAdapter
import academy.bangkit.muhamadlutfiarif.core.ui.viewmodel.ViewModelFactory
import academy.bangkit.muhamadlutfiarif.favorite.databinding.FragmentFavoriteTvShowBinding
import academy.bangkit.muhamadlutfiarif.favorite.di.DaggerFavoriteComponent
import academy.bangkit.muhamadlutfiarif.moviecatalogue.MyApplication
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

class FavoriteTvShowFragment : Fragment(), TvShowClickListener {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var binding: FragmentFavoriteTvShowBinding

    private val viewModel: FavoriteTvShowViewModel by viewModels {
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
        binding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val tvShowListAdapter = TvShowListAdapter(this)

            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, {
                if (it != null) {
                    tvShowListAdapter.setData(it)

                    with(binding.rvTvShows) {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = tvShowListAdapter
                    }
                }
            })
        }
    }

    override fun onItemClicked(catalogue: TvShow?) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", catalogue?.id)
        intent.putExtra("type", 1)
        startActivity(intent)
    }
}