package academy.bangkit.muhamadlutfiarif.core.data.source.local.room

import academy.bangkit.muhamadlutfiarif.core.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.core.data.source.local.entity.TvShowEntity
import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface CatalogueDao {

    @Query("SELECT * FROM movie_table")
    fun getMovies(): Flowable<List<MovieEntity>>

    @Query("SELECT * FROM tv_show_table")
    fun getTvShows(): Flowable<List<TvShowEntity>>

    @Query("SELECT * FROM movie_table WHERE is_favorite = 1")
    fun getFavoriteMovies(): Flowable<List<MovieEntity>>

    @Query("SELECT * FROM tv_show_table WHERE is_favorite = 1")
    fun getFavoriteTvShows(): Flowable<List<TvShowEntity>>

    @Query("SELECT * FROM movie_table WHERE id = :id")
    fun getMovieById(id: Int): Flowable<MovieEntity>

    @Query("SELECT * FROM tv_show_table WHERE id = :id")
    fun getTvShowById(id: Int): Flowable<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>): Completable

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}