package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.activities

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ActivityDetailBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie.MovieViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow.TvShowViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.viewmodel.ViewModelFactory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var tvShowViewModel: TvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catalogueId = intent.getIntExtra("id", 0)
        val catalogueType = intent.getIntExtra("type", 0)

        val factory = ViewModelFactory.getInstance(this)

        if (catalogueType == 0) {
            movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            movieViewModel.setMovieDetail(catalogueId)

            movieViewModel.movieDetail.observe(this, { movie ->
                with(binding) {
                    tvDetailTitle.text = movie.title
                    tvDetailReleaseDate.text = movie.releaseDate
                    tvDetailDuration.text = movie.duration
                    tvDetailUserScore.text = movie.userScore
                    tvDetailGenre.text = movie.genre
                    tvDetailOverview.text = movie.overview

                    Glide.with(applicationContext)
                            .load(applicationContext.resources.getIdentifier(movie.poster, "drawable", applicationContext.packageName))
                            .apply(RequestOptions().override(160, 240))
                            .into(imgDetailPoster)
                }

                binding.share.setOnClickListener {
                    val mimeType = "text/plain"
                    ShareCompat.IntentBuilder
                            .from(this)
                            .setType(mimeType)
                            .setChooserTitle(resources.getString(R.string.share))
                            .setText(resources.getString(R.string.share_item, movie.title))
                            .startChooser()
                }
            })
        } else {
            tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            tvShowViewModel.setTvShowDetail(catalogueId)

            tvShowViewModel.tvShowDetail.observe(this, { tvShow ->
                with(binding) {
                    tvDetailTitle.text = tvShow.title
                    tvDetailReleaseDate.text = tvShow.releaseDate
                    tvDetailDuration.text = tvShow.duration
                    tvDetailUserScore.text = tvShow.userScore
                    tvDetailGenre.text = tvShow.genre
                    tvDetailOverview.text = tvShow.overview

                    Glide.with(applicationContext)
                            .load(applicationContext.resources.getIdentifier(tvShow.poster, "drawable", applicationContext.packageName))
                            .apply(RequestOptions().override(160, 240))
                            .into(imgDetailPoster)
                }

                binding.share.setOnClickListener {
                    val mimeType = "text/plain"
                    ShareCompat.IntentBuilder
                            .from(this)
                            .setType(mimeType)
                            .setChooserTitle(resources.getString(R.string.share))
                            .setText(resources.getString(R.string.share_item, tvShow.title))
                            .startChooser()
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}