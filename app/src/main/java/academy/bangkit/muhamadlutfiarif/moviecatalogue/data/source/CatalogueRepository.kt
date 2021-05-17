package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote.RemoteDataSource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource): CatalogueDataSource {
    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): CatalogueRepository =
                instance ?: synchronized(this) {
                    instance ?: CatalogueRepository(remoteData).apply { instance = this }
                }
    }

    override fun getMovies(): LiveData<List<CatalogueEntity>> {
        val movieResponses = remoteDataSource.getMovies()
        val movieList = ArrayList<CatalogueEntity>()
        for (response in movieResponses) {
            val movie = CatalogueEntity(
                    response.id,
                    response.title,
                    response.releaseDate,
                    response.genre,
                    response.duration,
                    response.userScore,
                    response.overview,
                    response.poster
            )
            movieList.add(movie)
        }
        val result = MutableLiveData<List<CatalogueEntity>>()
        result.value = movieList
        return result
    }

    override fun getTvShows(): LiveData<List<CatalogueEntity>> {
        val tvShowResponses = remoteDataSource.getTvShows()
        val tvShowList = ArrayList<CatalogueEntity>()
        for (response in tvShowResponses) {
            val tvShow = CatalogueEntity(
                    response.id,
                    response.title,
                    response.releaseDate,
                    response.genre,
                    response.duration,
                    response.userScore,
                    response.overview,
                    response.poster
            )
            tvShowList.add(tvShow)
        }
        val result = MutableLiveData<List<CatalogueEntity>>()
        result.value = tvShowList
        return result
    }
}