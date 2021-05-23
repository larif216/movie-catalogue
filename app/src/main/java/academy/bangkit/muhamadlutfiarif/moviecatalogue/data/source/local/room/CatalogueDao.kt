package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.room

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CatalogueDao {

    @Query("SELECT * FROM movie_table")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tv_show_table")
    fun getTvShows(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM movie_table WHERE is_favorite = 1")
    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tv_show_table WHERE is_favorite = 1")
    fun getFavoriteTvShows(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM movie_table WHERE id = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tv_show_table WHERE id = :id")
    fun getTvShowById(id: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}