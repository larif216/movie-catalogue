package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentTvShowBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.CatalogueListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import androidx.recyclerview.widget.LinearLayoutManager

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

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
            val tvShows = DataDummy.generateDummyTvShows()
            val catalogueListAdapter = CatalogueListAdapter(tvShows)

            with(binding.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = catalogueListAdapter
            }
        }
    }
}