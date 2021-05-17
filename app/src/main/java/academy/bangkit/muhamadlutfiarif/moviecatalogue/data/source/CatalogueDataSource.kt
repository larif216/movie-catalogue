package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import androidx.lifecycle.LiveData

interface CatalogueDataSource {

    fun getMovies(): LiveData<List<CatalogueEntity>>

    fun getTvShows(): LiveData<List<CatalogueEntity>>
}