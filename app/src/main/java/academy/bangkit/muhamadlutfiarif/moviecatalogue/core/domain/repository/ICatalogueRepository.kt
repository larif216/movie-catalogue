package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.repository

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData
import io.reactivex.Flowable

interface ICatalogueRepository {

    fun getMovies(): Flowable<Resource<List<Movie>>>

    fun getTvShows(): Flowable<Resource<List<TvShow>>>

    fun getFavoriteMovies(): Flowable<List<Movie>>

    fun getFavoriteTvShows(): Flowable<List<TvShow>>

    fun getMovieById(id: Int): Flowable<Movie>

    fun getTvShowById(id: Int): Flowable<TvShow>

    fun setFavoriteMovie(movie: Movie, newState: Boolean)

    fun setFavoriteTvShow(tvShow: TvShow, newState: Boolean)
}