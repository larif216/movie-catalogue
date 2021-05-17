package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    fun getMovies(): LiveData<List<CatalogueEntity>> = catalogueRepository.getMovies()
}