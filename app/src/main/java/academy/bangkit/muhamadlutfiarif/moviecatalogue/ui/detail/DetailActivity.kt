package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ActivityDetailBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var catalogue: CatalogueEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            tvDetailTitle.text = catalogue.title
            tvDetailReleaseDate.text = catalogue.releaseDate
            tvDetailDuration.text = catalogue.duration
            tvDetailUserScore.text = catalogue.userScore
            tvDetailGenre.text = catalogue.genre
            tvDetailOverview.text = catalogue.overview

            Glide.with(applicationContext)
                .load(catalogue.poster)
                .apply(RequestOptions().override(160, 240))
                .into(imgDetailPoster)
        }
    }
}