package academy.bangkit.muhamadlutfiarif.core.di

import academy.bangkit.muhamadlutfiarif.core.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.core.domain.repository.ICatalogueRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(catalogueRepository: CatalogueRepository): ICatalogueRepository
}