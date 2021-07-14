package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class TvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    private val tvShowId = MutableLiveData<Int>()

    fun setSelectedTvShow(id: Int) {
        tvShowId.value = id
    }

    fun getTvShows(): LiveData<Resource<List<TvShow>>> = catalogueRepository.getTvShows()

    fun getFavoriteTvShows(): LiveData<List<TvShow>> = catalogueRepository.getFavoriteTvShows()

    var tvShowDetail: LiveData<TvShow> = Transformations.switchMap(tvShowId) { mTvShowId ->
        catalogueRepository.getTvShowById(mTvShowId)
    }

    fun setFavorite() {
        val tvShow = tvShowDetail.value
        if (tvShow != null) {
            val newState = !tvShow.isFavorite
            catalogueRepository.setFavoriteTvShow(tvShow, newState)
        }
    }
}