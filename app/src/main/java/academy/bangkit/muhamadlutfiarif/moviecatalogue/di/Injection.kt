package academy.bangkit.muhamadlutfiarif.moviecatalogue.di

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.LocalDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.room.CatalogueDatabase
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.AppExecutors
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.JsonHelper
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