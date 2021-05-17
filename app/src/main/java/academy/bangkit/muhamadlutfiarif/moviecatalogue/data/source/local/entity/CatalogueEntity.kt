package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class CatalogueEntity(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val genre: String,
    val duration: String,
    val userScore: String,
    val overview: String,
    val poster: String
): Parcelable
