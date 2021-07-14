package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.adapter

import academy.bangkit.muhamadlutfiarif.moviecatalogue.R
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.moviecatalogue.databinding.ItemsCatalogueBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieListAdapter(
    private val listener: MovieClickListener
): RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private val listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: ItemsCatalogueBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogue: Movie) {
            with(binding) {
                tvItemTitle.text = catalogue.title
                tvItemDate.text = catalogue.releaseDate
                tvItemUserScore.text = itemView.context.resources.getString(R.string.user_score, catalogue.userScore)
                Glide.with(itemView.context)
                    .load(itemView.context.resources.getIdentifier(catalogue.poster, "drawable", itemView.context.packageName))
                    .apply(RequestOptions().override(50, 75))
                    .into(binding.imgItemPoster)

                itemView.setOnClickListener {
                    listener.onItemClicked(listData[adapterPosition])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsCatalogueBinding = ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsCatalogueBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = listData[position]
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun getItemCount() = listData.size
}

interface MovieClickListener {
    fun onItemClicked(catalogue: Movie?)
}
