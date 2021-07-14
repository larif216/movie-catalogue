package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
        val id: Int,
        val title: String,
        val releaseDate: String,
        val genre: String,
        val duration: String,
        val userScore: String,
        val overview: String,
        val poster: String
): Parcelable
