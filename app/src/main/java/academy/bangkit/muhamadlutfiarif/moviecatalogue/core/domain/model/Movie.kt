package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val genre: String,
    val duration: String,
    val userScore: String,
    val overview: String,
    val poster: String,
    var isFavorite: Boolean = false
) : Parcelable
