package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class TvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val tvShowId = MutableLiveData<Int>()

    fun selectedTvShow(id: Int) {
        tvShowId.value = id
    }

    fun getTvShows(): LiveData<Resource<List<TvShowEntity>>> = catalogueRepository.getTvShows()

    fun getFavoriteTvShows(): LiveData<List<TvShowEntity>> = catalogueRepository.getFavoriteTvShows()

    var tvShowDetail: LiveData<TvShowEntity> = Transformations.switchMap(tvShowId) { mTvShowId ->
        catalogueRepository.getTvShowById(mTvShowId)
    }

    fun setFavorite() {
        val newState = !tvShowDetail.value!!.isFavorite
        catalogueRepository.setFavoriteTvShow(tvShowDetail.value!!, newState)
    }
}