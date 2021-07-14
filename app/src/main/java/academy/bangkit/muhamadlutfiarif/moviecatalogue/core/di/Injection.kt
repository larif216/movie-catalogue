package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.di

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.LocalDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.room.CatalogueDatabase
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.repository.ICatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase.CatalogueInteractor
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase.CatalogueUseCase
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.AppExecutors
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.JsonHelper
import android.content.Context

object Injection {
    fun provideRepository(context: Context): ICatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideCatalogueUseCase(context: Context): CatalogueUseCase {
        val repository = provideRepository(context)
        return CatalogueInteractor(repository)
    }
}