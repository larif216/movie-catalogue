package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(id: Int) {
        movieId.value = id
    }

    fun getMovies(): LiveData<Resource<List<Movie>>> = catalogueRepository.getMovies()

    fun getFavoriteMovies(): LiveData<List<Movie>> = catalogueRepository.getFavoriteMovies()

    var movieDetail: LiveData<Movie> = Transformations.switchMap(movieId) { mMovieId ->
        catalogueRepository.getMovieById(mMovieId)
    }

    fun setFavorite() {
        val movie = movieDetail.value
        if (movie != null) {
            val newState = !movie.isFavorite
            catalogueRepository.setFavoriteMovie(movie, newState)
        }
    }
}