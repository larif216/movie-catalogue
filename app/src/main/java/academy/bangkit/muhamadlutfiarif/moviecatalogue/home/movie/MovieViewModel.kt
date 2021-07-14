package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase.CatalogueUseCase
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MovieViewModel(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    private val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(id: Int) {
        movieId.value = id
    }

    fun getMovies(): LiveData<Resource<List<Movie>>> = catalogueUseCase.getMovies()

    fun getFavoriteMovies(): LiveData<List<Movie>> = catalogueUseCase.getFavoriteMovies()

    var movieDetail: LiveData<Movie> = Transformations.switchMap(movieId) { mMovieId ->
        catalogueUseCase.getMovieById(mMovieId)
    }

    fun setFavorite() {
        val movie = movieDetail.value
        if (movie != null) {
            val newState = !movie.isFavorite
            catalogueUseCase.setFavoriteMovie(movie, newState)
        }
    }
}