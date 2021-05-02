package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import androidx.lifecycle.ViewModel

class MovieViewModel: ViewModel() {

    fun getMovies(): List<CatalogueEntity> = DataDummy.generateDummyMovies()
}