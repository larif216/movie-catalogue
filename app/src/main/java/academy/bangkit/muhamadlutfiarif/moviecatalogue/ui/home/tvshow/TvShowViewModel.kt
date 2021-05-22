package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val _tvShowDetail = MutableLiveData<TvShowEntity>()
    val tvShowDetail: LiveData<TvShowEntity> = _tvShowDetail

    fun getTvShows(): LiveData<List<TvShowEntity>> = catalogueRepository.getTvShows()

    fun setTvShowDetail(id: Int) {
        val data = catalogueRepository.getTvShows()

        if (data != null) {
            for (item in data.value!!) {
                if (item.id == id) {
                    _tvShowDetail.value = item
                    break
                }
            }
        }
    }
}