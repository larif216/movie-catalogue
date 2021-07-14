package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.di

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.repository.ICatalogueRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(catalogueRepository: CatalogueRepository): ICatalogueRepository
}