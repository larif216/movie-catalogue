package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.viewmodel

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase.CatalogueUseCase
import academy.bangkit.muhamadlutfiarif.moviecatalogue.di.AppScope
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie.MovieViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow.TvShowViewModel
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val catalogueUseCase: CatalogueUseCase): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(catalogueUseCase) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(catalogueUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}