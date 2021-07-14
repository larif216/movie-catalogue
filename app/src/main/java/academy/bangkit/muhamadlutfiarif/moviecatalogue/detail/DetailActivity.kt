package academy.bangkit.muhamadlutfiarif.moviecatalogue.detail

import academy.bangkit.muhamadlutfiarif.moviecatalogue.MyApplication
import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ActivityDetailBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie.MovieViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow.TvShowViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.viewmodel.ViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var binding: ActivityDetailBinding

    private val movieViewModel: MovieViewModel by viewModels {
        factory
    }

    private val tvShowViewModel: TvShowViewModel by viewModels {
        factory
    }

    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catalogueId = intent.getIntExtra("id", 0)
        val catalogueType = intent.getIntExtra("type", 0)

        if (catalogueType == 0) {
            movieViewModel.setSelectedMovie(catalogueId)

            movieViewModel.movieDetail.observe(this, { movie ->
                with(binding) {
                    tvDetailTitle.text = movie.title
                    tvDetailReleaseDate.text = movie.releaseDate
                    tvDetailUserScore.text = movie.userScore
                    tvDetailOverview.text = movie.overview

                    Glide.with(applicationContext)
                            .load("${RemoteDataSource.IMAGE_DOMAIN}${movie.poster}")
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
            tvShowViewModel.setSelectedTvShow(catalogueId)

            tvShowViewModel.tvShowDetail.observe(this, { tvShow ->
                with(binding) {
                    tvDetailTitle.text = tvShow.title
                    tvDetailReleaseDate.text = tvShow.releaseDate
                    tvDetailUserScore.text = tvShow.userScore
                    tvDetailOverview.text = tvShow.overview

                    Glide.with(applicationContext)
                            .load("${RemoteDataSource.IMAGE_DOMAIN}${tvShow.poster}")
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
        this.menu = menu
        val catalogueType = intent.getIntExtra("type", 0)

        if (catalogueType == 0) {
            movieViewModel.movieDetail.observe(this, {
                val state = it.isFavorite
                setFavoriteState(state)
            })
        } else {
            tvShowViewModel.tvShowDetail.observe(this, {
                val state = it.isFavorite
                setFavoriteState(state)
            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite_btn) {
            val catalogueType = intent.getIntExtra("type", 0)
            return if (catalogueType == 0) {
                movieViewModel.setFavorite()
                true
            } else {
                tvShowViewModel.setFavorite()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite_btn)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }
}