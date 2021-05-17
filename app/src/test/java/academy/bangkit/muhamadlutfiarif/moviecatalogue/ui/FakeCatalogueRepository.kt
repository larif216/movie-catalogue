package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote.RemoteDataSource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource): CatalogueDataSource {

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
        result.postValue(movieList)
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
        result.postValue(tvShowList)
        return result
    }
}