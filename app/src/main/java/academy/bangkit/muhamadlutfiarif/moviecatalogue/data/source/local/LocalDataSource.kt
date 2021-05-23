package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.room.CatalogueDao
import androidx.lifecycle.LiveData
import androidx.paging.DataSource

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }

    fun getMovies(): DataSource.Factory<Int, MovieEntity> = mCatalogueDao.getMovies()

    fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = mCatalogueDao.getTvShows()

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mCatalogueDao.getFavoriteMovies()

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> = mCatalogueDao.getFavoriteTvShows()

    fun getMovieById(id: Int): LiveData<MovieEntity> = mCatalogueDao.getMovieById(id)

    fun getTvShowById(id: Int): LiveData<TvShowEntity> = mCatalogueDao.getTvShowById(id)

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