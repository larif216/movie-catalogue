package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val _selectedCatalogue = MutableLiveData<CatalogueEntity>()
    val selectedCatalogue: LiveData<CatalogueEntity> = _selectedCatalogue

    companion object {
        const val TYPE_MOVIE = 0
        const val TYPE_TV_SHOW = 1
    }

    fun setCatalogueDetail(catalogueId: Int, type: Int) {
        val data = if (type == TYPE_MOVIE) {
            catalogueRepository.getMovies()
        } else {
            catalogueRepository.getTvShows()
        }

        for (item in data) {
            if (item.id == catalogueId) {
                _selectedCatalogue.value = item
                break
            }
        }
    }
}