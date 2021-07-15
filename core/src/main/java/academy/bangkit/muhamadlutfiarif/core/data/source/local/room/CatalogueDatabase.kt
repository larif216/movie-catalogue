package academy.bangkit.muhamadlutfiarif.core.data.source.local.room

import academy.bangkit.muhamadlutfiarif.core.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.core.data.source.local.entity.TvShowEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false)
abstract class CatalogueDatabase: RoomDatabase() {
    abstract fun catalogueDao(): CatalogueDao
}