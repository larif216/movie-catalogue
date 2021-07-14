package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.di

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.LocalDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.room.CatalogueDatabase
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.AppExecutors
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.JsonHelper
import android.content.Context

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}