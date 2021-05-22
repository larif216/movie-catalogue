package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }
}