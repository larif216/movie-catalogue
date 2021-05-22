package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val _movieDetail = MutableLiveData<MovieEntity>()
    val movieDetail: LiveData<MovieEntity> = _movieDetail

    fun getMovies(): LiveData<List<MovieEntity>> = catalogueRepository.getMovies()

    fun setMovieDetail(id: Int) {
        val data = catalogueRepository.getMovies()

        if (data != null) {
            for (item in data.value!!) {
                if (item.id == id) {
                    _movieDetail.value = item
                    break
                }
            }
        }
    }
}