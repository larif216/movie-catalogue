package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity

@Parcelize
@Entity(tableName = "movie_table")
data class MovieEntity(
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "duration")
    val duration: String,

    @ColumnInfo(name = "user_score")
    val userScore: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "poster")
    val poster: String
): Parcelable
