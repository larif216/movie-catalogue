package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val _movies = MutableLiveData<List<CatalogueEntity>>()
    val movies: LiveData<List<CatalogueEntity>> = _movies

    init {
        _movies.value = getMovies()
    }

    fun getMovies(): List<CatalogueEntity> = catalogueRepository.getMovies()
}