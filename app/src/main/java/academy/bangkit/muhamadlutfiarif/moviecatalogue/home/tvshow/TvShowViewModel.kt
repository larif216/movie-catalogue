package academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase.CatalogueUseCase
import androidx.lifecycle.*

class TvShowViewModel(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    private val tvShowId = MutableLiveData<Int>()

    fun setSelectedTvShow(id: Int) {
        tvShowId.value = id
    }

    fun getTvShows() = LiveDataReactiveStreams.fromPublisher(catalogueUseCase.getTvShows())

    fun getFavoriteTvShows() = LiveDataReactiveStreams.fromPublisher(catalogueUseCase.getFavoriteTvShows())

    var tvShowDetail = Transformations.switchMap(tvShowId) { mTvShowId ->
        LiveDataReactiveStreams.fromPublisher(catalogueUseCase.getTvShowById(mTvShowId))
    }

    fun setFavorite() {
        val tvShow = tvShowDetail.value
        if (tvShow != null) {
            val newState = !tvShow.isFavorite
            catalogueUseCase.setFavoriteTvShow(tvShow, newState)
        }
    }
}