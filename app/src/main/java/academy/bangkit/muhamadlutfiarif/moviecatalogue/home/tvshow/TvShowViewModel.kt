package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase.CatalogueUseCase
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class TvShowViewModel(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    private val tvShowId = MutableLiveData<Int>()

    fun setSelectedTvShow(id: Int) {
        tvShowId.value = id
    }

    fun getTvShows(): LiveData<Resource<List<TvShow>>> = catalogueUseCase.getTvShows()

    fun getFavoriteTvShows(): LiveData<List<TvShow>> = catalogueUseCase.getFavoriteTvShows()

    var tvShowDetail: LiveData<TvShow> = Transformations.switchMap(tvShowId) { mTvShowId ->
        catalogueUseCase.getTvShowById(mTvShowId)
    }

    fun setFavorite() {
        val tvShow = tvShowDetail.value
        if (tvShow != null) {
            val newState = !tvShow.isFavorite
            catalogueUseCase.setFavoriteTvShow(tvShow, newState)
        }
    }
}