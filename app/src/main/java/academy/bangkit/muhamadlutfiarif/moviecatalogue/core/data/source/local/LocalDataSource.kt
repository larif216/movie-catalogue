package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.room.CatalogueDao
import androidx.lifecycle.LiveData
import io.reactivex.Flowable

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }

    fun getMovies(): Flowable<List<MovieEntity>> = mCatalogueDao.getMovies()

    fun getTvShows(): Flowable<List<TvShowEntity>> = mCatalogueDao.getTvShows()

    fun getFavoriteMovies(): Flowable<List<MovieEntity>> = mCatalogueDao.getFavoriteMovies()

    fun getFavoriteTvShows(): Flowable<List<TvShowEntity>> = mCatalogueDao.getFavoriteTvShows()

    fun getMovieById(id: Int): Flowable<MovieEntity> = mCatalogueDao.getMovieById(id)

    fun getTvShowById(id: Int): Flowable<TvShowEntity> = mCatalogueDao.getTvShowById(id)

    fun insertMovies(movies: List<MovieEntity>) = mCatalogueDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mCatalogueDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mCatalogueDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        mCatalogueDao.updateTvShow(tvShow)
    }
}