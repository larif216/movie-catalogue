package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse(
        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("name")
        val title: String,

        @field:SerializedName("first_air_date")
        val releaseDate: String,

        @field:SerializedName("vote_average")
        val userScore: Double,

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("poster_path")
        val poster: String
): Parcelable
