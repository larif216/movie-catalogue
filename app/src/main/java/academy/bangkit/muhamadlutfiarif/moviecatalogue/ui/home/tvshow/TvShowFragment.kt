package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.FragmentTvShowBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.DetailActivity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.TvShowClickListener
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.TvShowListAdapter
import academy.bangkit.muhamadlutfiarif.moviecatalogue.viewmodel.ViewModelFactory
import academy.bangkit.muhamadlutfiarif.moviecatalogue.vo.Status
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class TvShowFragment : Fragment(), TvShowClickListener {

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
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            viewModel.getTvShows().observe(this, {
                if (it != null) {
                    when (it.status) {
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            val tvShowListAdapter = TvShowListAdapter(it.data!!, this)
                            tvShowListAdapter.notifyDataSetChanged()

                            with(binding.rvTvShows) {
                                layoutManager = LinearLayoutManager(context)
                                setHasFixedSize(true)
                                adapter = tvShowListAdapter
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

    override fun onItemClicked(catalogue: TvShowEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", catalogue.id)
        intent.putExtra("type", 1)
        startActivity(intent)
    }
}