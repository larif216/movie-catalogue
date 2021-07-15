package academy.bangkit.muhamadlutfiarif.moviecatalogue.di

import academy.bangkit.muhamadlutfiarif.core.di.CoreComponent
import academy.bangkit.muhamadlutfiarif.moviecatalogue.detail.DetailActivity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.favorite.movie.FavoriteMovieFragment
import academy.bangkit.muhamadlutfiarif.moviecatalogue.favorite.tvshow.FavoriteTvShowFragment
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.movie.MovieFragment
import academy.bangkit.muhamadlutfiarif.moviecatalogue.home.tvshow.TvShowFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: MovieFragment)
    fun inject(fragment: TvShowFragment)
    fun inject(fragment: FavoriteMovieFragment)
    fun inject(fragment: FavoriteTvShowFragment)
    fun inject(activity: DetailActivity)
}