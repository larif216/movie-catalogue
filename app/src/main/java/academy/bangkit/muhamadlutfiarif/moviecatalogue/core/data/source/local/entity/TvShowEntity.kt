package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tv_show_table")
data class TvShowEntity(
        @PrimaryKey
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
        val poster: String,

        @ColumnInfo(name = "is_favorite")
        var isFavorite: Boolean = false
): Parcelable
