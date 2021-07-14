package academy.bangkit.muhamadlutfiarif.moviecatalogue.favorite.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.adapter.TvShowClickListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.detail.DetailActivity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.adapter.TvShowListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow.TvShowViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.viewmodel.ViewModelFactory
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
            val tvShowListAdapter = TvShowListAdapter(this)

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            viewModel.getFavoriteTvShows().observe(this, {
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