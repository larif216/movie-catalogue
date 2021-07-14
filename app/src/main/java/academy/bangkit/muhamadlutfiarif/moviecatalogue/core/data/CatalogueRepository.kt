package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.local.LocalDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.network.ApiResponse
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
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : ICatalogueRepository {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): CatalogueRepository =
                instance ?: synchronized(this) {
                    instance ?: CatalogueRepository(remoteData, localData, appExecutors).apply { instance = this }
                }
    }

    override fun getMovies(): Flowable<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): Flowable<List<Movie>> {
                return localDataSource.getMovies().map { DataMapper.mapMovieEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            public override fun createCall(): Flowable<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getMovies()
            }

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapMovieResponseToEntities(data)
                localDataSource.insertMovies(movieList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()
    }

    override fun getTvShows(): Flowable<Resource<List<TvShow>>> {
        return object : NetworkBoundResource<List<TvShow>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): Flowable<List<TvShow>> {
                return localDataSource.getTvShows().map { DataMapper.mapTvShowEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean {
                return data == null || data.isEmpty()
            }

            public override fun createCall(): Flowable<ApiResponse<List<TvShowResponse>>> {
                return remoteDataSource.getTvShows()
            }

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = DataMapper.mapTvShowResponseToEntities(data)
                localDataSource.insertTvShows(tvShowList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()
    }

    override fun getFavoriteMovies(): Flowable<List<Movie>> {
        return localDataSource.getFavoriteMovies().map { DataMapper.mapMovieEntitiesToDomain(it) }
    }

    override fun getFavoriteTvShows(): Flowable<List<TvShow>> {
        return localDataSource.getFavoriteTvShows().map { DataMapper.mapTvShowEntitiesToDomain(it) }
    }

    override fun getMovieById(id: Int): Flowable<Movie> {
        return localDataSource.getMovieById(id).map { DataMapper.mapMovieEntityToDomain(it) }
    }

    override fun getTvShowById(id: Int): Flowable<TvShow> {
        return localDataSource.getTvShowById(id).map { DataMapper.mapTvShowEntityToDomain(it) }
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