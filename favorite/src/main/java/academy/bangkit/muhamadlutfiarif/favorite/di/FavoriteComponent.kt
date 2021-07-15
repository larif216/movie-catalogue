package academy.bangkit.muhamadlutfiarif.favorite.di

import academy.bangkit.muhamadlutfiarif.core.di.CoreComponent
import academy.bangkit.muhamadlutfiarif.favorite.movie.FavoriteMovieFragment
import academy.bangkit.muhamadlutfiarif.favorite.tvshow.FavoriteTvShowFragment
import academy.bangkit.muhamadlutfiarif.moviecatalogue.di.AppScope
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [FavoriteModule::class, ViewModelModule::class]
)
interface FavoriteComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): FavoriteComponent
    }

    fun inject(fragment: FavoriteMovieFragment)
    fun inject(fragment: FavoriteTvShowFragment)
}