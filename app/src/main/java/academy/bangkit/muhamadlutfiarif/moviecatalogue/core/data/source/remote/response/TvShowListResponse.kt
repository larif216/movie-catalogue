package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowListResponse(
    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("results")
    val tvShows: List<TvShowResponse>
): Parcelable
