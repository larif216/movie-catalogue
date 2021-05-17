package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val _tvShows = MutableLiveData<List<CatalogueEntity>>()
    val tvShows: LiveData<List<CatalogueEntity>> = _tvShows

    init {
        _tvShows.value = getTvShows()
    }

    fun getTvShows(): List<CatalogueEntity> = catalogueRepository.getTvShows()
}