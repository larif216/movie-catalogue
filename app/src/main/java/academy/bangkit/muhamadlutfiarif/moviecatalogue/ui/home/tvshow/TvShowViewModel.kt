package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import androidx.lifecycle.ViewModel

class TvShowViewModel: ViewModel() {

    fun getTvShows(): List<CatalogueEntity> = DataDummy.generateDummyTvShows()
}