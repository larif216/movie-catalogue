package academy.bangkit.muhamadlutfiarif.core.data.source.local.entity

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Parcelize
@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "user_score")
    val userScore: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "poster")
    val poster: String?,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
): Parcelable
