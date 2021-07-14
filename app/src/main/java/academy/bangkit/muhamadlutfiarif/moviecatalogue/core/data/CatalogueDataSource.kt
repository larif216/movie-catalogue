package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData
import androidx.paging.PagedList

interface CatalogueDataSource {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>

    fun getMovieById(id: Int): LiveData<MovieEntity>

    fun getTvShowById(id: Int): LiveData<TvShowEntity>

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean)
}