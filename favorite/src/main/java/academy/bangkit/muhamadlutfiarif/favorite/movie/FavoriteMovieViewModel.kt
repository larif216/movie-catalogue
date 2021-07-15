package academy.bangkit.muhamadlutfiarif.favorite.movie

import academy.bangkit.muhamadlutfiarif.core.domain.usecase.CatalogueUseCase
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class FavoriteMovieViewModel @Inject constructor(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    private val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(id: Int) {
        movieId.value = id
    }

    fun getFavoriteMovies() = LiveDataReactiveStreams.fromPublisher(catalogueUseCase.getFavoriteMovies())

    var movieDetail = Transformations.switchMap(movieId) { mMovieId ->
        LiveDataReactiveStreams.fromPublisher(catalogueUseCase.getMovieById(mMovieId))
    }

    fun setFavorite() {
        val movie = movieDetail.value
        if (movie != null) {
            val newState = !movie.isFavorite
            catalogueUseCase.setFavoriteMovie(movie, newState)
        }
    }
}