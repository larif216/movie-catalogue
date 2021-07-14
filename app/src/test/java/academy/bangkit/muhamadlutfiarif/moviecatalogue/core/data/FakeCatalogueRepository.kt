package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.LocalDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.ApiResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.MovieResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.TvShowResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.repository.ICatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.AppExecutors
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.DataMapper
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

class FakeCatalogueRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : ICatalogueRepository {

    override fun getMovies(): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<Movie>> {
                return Transformations.map(localDataSource.getMovies()) {
                    DataMapper.mapMovieEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getMovies()
            }

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapMovieResponseToEntities(data)
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getTvShows(): LiveData<Resource<List<TvShow>>> {
        return object : NetworkBoundResource<List<TvShow>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TvShow>> {
                return Transformations.map(localDataSource.getTvShows()) {
                    DataMapper.mapTvShowEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean {
                return data == null || data.isEmpty()
            }

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> {
                return remoteDataSource.getTvShows()
            }

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = DataMapper.mapTvShowResponseToEntities(data)
                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<List<Movie>> {
        return Transformations.map(localDataSource.getFavoriteMovies()) {
            DataMapper.mapMovieEntitiesToDomain(it)
        }
    }

    override fun getFavoriteTvShows(): LiveData<List<TvShow>> {
        return Transformations.map(localDataSource.getTvShows()) {
            DataMapper.mapTvShowEntitiesToDomain(it)
        }
    }

    override fun getMovieById(id: Int): LiveData<Movie> {
        return Transformations.map(localDataSource.getMovieById(id)) {
            DataMapper.mapMovieEntityToDomain(it)
        }
    }

    override fun getTvShowById(id: Int): LiveData<TvShow> {
        return Transformations.map(localDataSource.getTvShowById(id)) {
            DataMapper.mapTvShowEntityToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, newState: Boolean) {
        val movieEntity = DataMapper.mapMovieDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, newState) }
    }

    override fun setFavoriteTvShow(tvShow: TvShow, newState: Boolean) {
        val tvShowEntity = DataMapper.mapTvShowDomainToEntity(tvShow)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShowEntity, newState) }
    }
}