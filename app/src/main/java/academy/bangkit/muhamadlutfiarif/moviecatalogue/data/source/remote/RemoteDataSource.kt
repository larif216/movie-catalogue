package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(helper).apply { instance = this }
                }
    }

    fun getMovies(): List<CatalogueEntity> = jsonHelper.loadCatalogue(JsonHelper.FILE_MOVIE)

    fun getTvShows(): List<CatalogueEntity> = jsonHelper.loadCatalogue(JsonHelper.FILE_TV_SHOW)
}