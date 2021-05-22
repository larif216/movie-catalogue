package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote.RemoteDataSource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource): CatalogueDataSource {

    override fun getMovies(): LiveData<List<MovieEntity>> {
        val movieResponses = remoteDataSource.getMovies()
        val movieList = ArrayList<MovieEntity>()
        for (response in movieResponses) {
            val movie = MovieEntity(
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
        val result = MutableLiveData<List<MovieEntity>>()
        result.postValue(movieList)
        return result
    }

    override fun getTvShows(): LiveData<List<TvShowEntity>> {
        val tvShowResponses = remoteDataSource.getTvShows()
        val tvShowList = ArrayList<TvShowEntity>()
        for (response in tvShowResponses) {
            val tvShow = TvShowEntity(
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
        val result = MutableLiveData<List<TvShowEntity>>()
        result.postValue(tvShowList)
        return result
    }
}