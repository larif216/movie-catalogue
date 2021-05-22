package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.room

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM movie_table")
    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tv_show_table")
    fun getFavoriteTvShows(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM movie_table WHERE id = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tv_show_table WHERE id = :id")
    fun getTvShowById(id: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: TvShowEntity)

    @Delete
    fun deleteMovie(movie: MovieEntity)

    @Delete
    fun deleteTvShow(tvShow: TvShowEntity)
}