package academy.bangkit.muhamadlutfiarif.core.di

import academy.bangkit.muhamadlutfiarif.core.data.source.local.room.CatalogueDao
import academy.bangkit.muhamadlutfiarif.core.data.source.local.room.CatalogueDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): CatalogueDatabase = Room.databaseBuilder(
        context,
        CatalogueDatabase::class.java,
        "Catalogue.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideCatalogueDao(database: CatalogueDatabase): CatalogueDao = database.catalogueDao()
}