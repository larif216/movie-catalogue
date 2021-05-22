package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowEntity(
        val id: Int,
        val title: String,
        val releaseDate: String,
        val genre: String,
        val duration: String,
        val userScore: String,
        val overview: String,
        val poster: String
): Parcelable
