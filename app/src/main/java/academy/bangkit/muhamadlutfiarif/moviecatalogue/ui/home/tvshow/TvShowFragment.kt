package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentTvShowBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail.DetailActivity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail.DetailViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.CatalogueClickListener
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.CatalogueListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class TvShowFragment : Fragment(), CatalogueClickListener {

    private lateinit var binding: FragmentTvShowBinding
    private lateinit var viewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvShows = viewModel.getTvShows()
            val catalogueListAdapter = CatalogueListAdapter(tvShows, this)

            with(binding.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = catalogueListAdapter
            }
        }
    }

    override fun onItemClicked(catalogue: CatalogueEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", catalogue.id)
        intent.putExtra("type", DetailViewModel.TYPE_TV_SHOW)
        startActivity(intent)
    }
}