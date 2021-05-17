package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    fun getTvShows(): LiveData<List<CatalogueEntity>> = catalogueRepository.getTvShows()
}