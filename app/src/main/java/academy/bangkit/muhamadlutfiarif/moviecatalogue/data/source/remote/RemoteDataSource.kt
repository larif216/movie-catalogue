package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
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

    fun getMovies(): List<MovieEntity> = jsonHelper.loadMovies(JsonHelper.FILE_MOVIE)

    fun getTvShows(): List<TvShowEntity> = jsonHelper.loadTvShows(JsonHelper.FILE_TV_SHOW)
}