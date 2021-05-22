package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ItemsCatalogueBinding
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.adapter.TvShowListAdapter.TvShowViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowListAdapter(
        private val listItems: List<TvShowEntity>,
        private val listener: TvShowClickListener
): RecyclerView.Adapter<TvShowViewHolder>() {

    inner class TvShowViewHolder(private val binding: ItemsCatalogueBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogue: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = catalogue.title
                tvItemDate.text = catalogue.releaseDate
                tvItemUserScore.text = itemView.context.resources.getString(R.string.user_score, catalogue.userScore)
                Glide.with(itemView.context)
                        .load(itemView.context.resources.getIdentifier(catalogue.poster, "drawable", itemView.context.packageName))
                        .apply(RequestOptions().override(50, 75))
                        .into(binding.imgItemPoster)

                itemView.setOnClickListener {
                    listener.onItemClicked(listItems[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsCatalogueBinding = ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsCatalogueBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val item = listItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}

interface TvShowClickListener {
    fun onItemClicked(catalogue: TvShowEntity)
}