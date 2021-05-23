package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

class MovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val movieId = MutableLiveData<Int>()

    fun selectedMovie(id: Int) {
        movieId.value = id
    }

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = catalogueRepository.getMovies()

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = catalogueRepository.getFavoriteMovies()

    var movieDetail: LiveData<MovieEntity> = Transformations.switchMap(movieId) { mMovieId ->
        catalogueRepository.getMovieById(mMovieId)
    }

    fun setFavorite() {
        val newState = !movieDetail.value!!.isFavorite
        catalogueRepository.setFavoriteMovie(movieDetail.value!!, newState)
    }
}