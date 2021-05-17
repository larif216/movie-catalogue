package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ActivityDetailBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.viewmodel.ViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.view.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catalogueId = intent.getIntExtra("id", 0)
        val catalogueType = intent.getIntExtra("type", 0)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        viewModel.setCatalogueDetail(catalogueId, catalogueType)

        viewModel.selectedCatalogue.observe(this, { catalogue ->
            with(binding) {
                tvDetailTitle.text = catalogue.title
                tvDetailReleaseDate.text = catalogue.releaseDate
                tvDetailDuration.text = catalogue.duration
                tvDetailUserScore.text = catalogue.userScore
                tvDetailGenre.text = catalogue.genre
                tvDetailOverview.text = catalogue.overview

                Glide.with(applicationContext)
                        .load(applicationContext.resources.getIdentifier(catalogue.poster, "drawable", applicationContext.packageName))
                        .apply(RequestOptions().override(160, 240))
                        .into(imgDetailPoster)

            }
            binding.share.setOnClickListener {
                val mimeType = "text/plain"
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType(mimeType)
                        .setChooserTitle(resources.getString(R.string.share))
                        .setText(resources.getString(R.string.share_item, catalogue.title))
                        .startChooser()
            }
        })
    }
}