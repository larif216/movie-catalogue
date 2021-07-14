package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData

interface CatalogueUseCase {

    fun getMovies(): LiveData<Resource<List<Movie>>>

    fun getTvShows(): LiveData<Resource<List<TvShow>>>

    fun getFavoriteMovies(): LiveData<List<Movie>>

    fun getFavoriteTvShows(): LiveData<List<TvShow>>

    fun getMovieById(id: Int): LiveData<Movie>

    fun getTvShowById(id: Int): LiveData<TvShow>

    fun setFavoriteMovie(movie: Movie, newState: Boolean)

    fun setFavoriteTvShow(tvShow: TvShow, newState: Boolean)
}