package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel() {

    private lateinit var selectedCatalogue: CatalogueEntity

    companion object {
        const val TYPE_MOVIE = 0
        const val TYPE_TV_SHOW = 1
    }

    fun setCatalogueDetail(catalogueId: Int, type: Int) {
        val data = if (type == TYPE_MOVIE) {
            DataDummy.generateDummyMovies()
        } else {
            DataDummy.generateDummyTvShows()
        }

        for (item in data) {
            if (item.id == catalogueId) {
                selectedCatalogue = item
                break
            }
        }
    }

    fun getCatalogueDetail(): CatalogueEntity {
        return selectedCatalogue
    }
}