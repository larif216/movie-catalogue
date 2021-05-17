package academy.bangkit.muhamadlutfiarif.moviecatalogue.di

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.JsonHelper
import android.content.Context

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return CatalogueRepository.getInstance(remoteDataSource)
    }
}