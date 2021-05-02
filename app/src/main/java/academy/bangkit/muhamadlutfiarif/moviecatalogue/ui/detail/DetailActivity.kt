package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ActivityDetailBinding
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

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        viewModel.setCatalogueDetail(catalogueId, catalogueType)

        val catalogue = viewModel.getCatalogueDetail()

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

        binding.share.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(resources.getString(R.string.share))
                .setText(resources.getString(R.string.share_item, catalogue.title))
                .startChooser()
        }
    }
}