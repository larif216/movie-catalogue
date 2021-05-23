package academy.bangkit.muhamadlutfiarif.moviecatalogue.data

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.vo.Resource
import androidx.lifecycle.LiveData

interface CatalogueDataSource {

    fun getMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getTvShows(): LiveData<Resource<List<TvShowEntity>>>

    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    fun getFavoriteTvShows(): LiveData<List<TvShowEntity>>

    fun getMovieById(id: Int): LiveData<MovieEntity>

    fun getTvShowById(id: Int): LiveData<TvShowEntity>

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean)
}