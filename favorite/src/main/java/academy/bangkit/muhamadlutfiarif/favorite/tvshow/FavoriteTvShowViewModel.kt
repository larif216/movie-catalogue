package academy.bangkit.muhamadlutfiarif.favorite.tvshow

import academy.bangkit.muhamadlutfiarif.core.domain.usecase.CatalogueUseCase
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class FavoriteTvShowViewModel @Inject constructor(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    private val tvShowId = MutableLiveData<Int>()

    fun setSelectedTvShow(id: Int) {
        tvShowId.value = id
    }

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