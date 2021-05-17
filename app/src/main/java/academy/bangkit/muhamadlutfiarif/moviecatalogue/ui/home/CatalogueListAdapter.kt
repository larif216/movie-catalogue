package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ItemsCatalogueBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CatalogueListAdapter(
        private val listItems: List<CatalogueEntity>,
        private val listener: CatalogueClickListener
): RecyclerView.Adapter<CatalogueListAdapter.CatalogueViewHolder>() {

    inner class CatalogueViewHolder(private val binding: ItemsCatalogueBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogue: CatalogueEntity) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueViewHolder {
        val itemsCatalogueBinding = ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogueViewHolder(itemsCatalogueBinding)
    }

    override fun onBindViewHolder(holder: CatalogueViewHolder, position: Int) {
        val item = listItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}

interface CatalogueClickListener {
    fun onItemClicked(catalogue: CatalogueEntity)
}
