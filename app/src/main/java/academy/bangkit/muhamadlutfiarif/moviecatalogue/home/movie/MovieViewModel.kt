package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase.CatalogueUseCase
import androidx.lifecycle.*

class MovieViewModel(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    private val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(id: Int) {
        movieId.value = id
    }

    fun getMovies() = LiveDataReactiveStreams.fromPublisher(catalogueUseCase.getMovies())

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