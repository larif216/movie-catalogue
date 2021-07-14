package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.adapter

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ItemsCatalogueBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowListAdapter(
    private val listener: TvShowClickListener
): RecyclerView.Adapter<TvShowListAdapter.TvShowViewHolder>() {

    private val listData = ArrayList<TvShow>()
    var onItemClick: ((TvShow) -> Unit)? = null

    fun setData(newListData: List<TvShow>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class TvShowViewHolder(private val binding: ItemsCatalogueBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogue: TvShow) {
            with(binding) {
                tvItemTitle.text = catalogue.title
                tvItemDate.text = catalogue.releaseDate
                tvItemUserScore.text = itemView.context.resources.getString(R.string.user_score, catalogue.userScore)
                Glide.with(itemView.context)
                        .load("${RemoteDataSource.IMAGE_DOMAIN}${catalogue.poster}")
                        .apply(RequestOptions().override(50, 75))
                        .into(binding.imgItemPoster)

                itemView.setOnClickListener {
                    listener.onItemClicked(listData[adapterPosition])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsCatalogueBinding = ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsCatalogueBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val item = listData[position]
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun getItemCount() = listData.size
}

interface TvShowClickListener {
    fun onItemClicked(catalogue: TvShow?)
}
