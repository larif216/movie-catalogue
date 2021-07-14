package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.ui.viewmodel

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.di.Injection
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase.CatalogueUseCase
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie.MovieViewModel
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow.TvShowViewModel
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory private constructor(private val catalogueUseCase: CatalogueUseCase): ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideCatalogueUseCase(context)).apply { instance = this }
                }
    }

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