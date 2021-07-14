package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("title")
        val title: String,

        @field:SerializedName("release_date")
        val releaseDate: String,

        @field:SerializedName("vote_average")
        val userScore: Double,

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("poster_path")
        val poster: String
): Parcelable
