package academy.bangkit.muhamadlutfiarif.favorite.di

import academy.bangkit.muhamadlutfiarif.favorite.movie.FavoriteMovieViewModel
import academy.bangkit.muhamadlutfiarif.favorite.tvshow.FavoriteTvShowViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FavoriteMovieViewModel::class)
    abstract fun bindFavoriteMovieViewModel(viewModel: FavoriteMovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteTvShowViewModel::class)
    abstract fun bindFavoriteTvShowViewModel(viewModel: FavoriteTvShowViewModel): ViewModel
}