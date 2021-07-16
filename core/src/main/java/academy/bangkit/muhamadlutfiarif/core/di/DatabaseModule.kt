package academy.bangkit.muhamadlutfiarif.core.di

import academy.bangkit.muhamadlutfiarif.core.data.source.local.room.CatalogueDao
import academy.bangkit.muhamadlutfiarif.core.data.source.local.room.CatalogueDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): CatalogueDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("moviecatalogue".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            CatalogueDatabase::class.java,
            "Catalogue.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideCatalogueDao(database: CatalogueDatabase): CatalogueDao = database.catalogueDao()
}