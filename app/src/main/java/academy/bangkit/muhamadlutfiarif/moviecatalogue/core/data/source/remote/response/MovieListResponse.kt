package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieListResponse(
    @field:SerializedName ("page")
    val page: Int,

    @field:SerializedName("results")
    val movies: List<MovieResponse>
): Parcelable
