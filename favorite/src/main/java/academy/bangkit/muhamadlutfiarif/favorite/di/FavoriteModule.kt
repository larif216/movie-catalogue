package academy.bangkit.muhamadlutfiarif.favorite.di

import academy.bangkit.muhamadlutfiarif.core.domain.usecase.CatalogueInteractor
import academy.bangkit.muhamadlutfiarif.core.domain.usecase.CatalogueUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class FavoriteModule {
    @Binds
    abstract fun provideCatalogueUseCase(catalogueInteractor: CatalogueInteractor): CatalogueUseCase
}