package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

class TvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val tvShowId = MutableLiveData<Int>()

    fun setSelectedTvShow(id: Int) {
        tvShowId.value = id
    }

    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = catalogueRepository.getTvShows()

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = catalogueRepository.getFavoriteTvShows()

    var tvShowDetail: LiveData<TvShowEntity> = Transformations.switchMap(tvShowId) { mTvShowId ->
        catalogueRepository.getTvShowById(mTvShowId)
    }

    fun setFavorite() {
        val tvShowEntity = tvShowDetail.value
        if (tvShowEntity != null) {
            val newState = !tvShowEntity.isFavorite
            catalogueRepository.setFavoriteTvShow(tvShowEntity, newState)
        }
    }
}