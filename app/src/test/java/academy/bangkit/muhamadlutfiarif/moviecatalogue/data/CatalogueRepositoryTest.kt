package academy.bangkit.muhamadlutfiarif.moviecatalogue.data

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.LocalDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.*
import academy.bangkit.muhamadlutfiarif.moviecatalogue.vo.Resource
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class CatalogueRepositoryTest {

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val testExecutor = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateDummyMoviesResponse()
    private val movieId = movieResponses[0].id
    private val tvShowResponses = DataDummy.generateDummyTvShowsResponse()
    private val tvShowId = tvShowResponses[0].id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteMovies()

        val favoriteMovieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(favoriteMovieEntities.data)
        assertEquals(movieResponses.size.toLong(), favoriteMovieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteTvShows()

        val favoriteTvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getFavoriteTvShows()
        assertNotNull(favoriteTvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), favoriteTvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieById() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.generateDummyMovies()[movieId]
        `when`(local.getMovieById(movieId)).thenReturn(dummyMovie)

        val movieEntity = LiveDataTestUtil.getValue(catalogueRepository.getMovieById(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.value, movieEntity)
    }

    @Test
    fun getTvShowById() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = DataDummy.generateDummyTvShows()[tvShowId]
        `when`(local.getTvShowById(tvShowId)).thenReturn(dummyTvShow)

        val tvShowEntity = LiveDataTestUtil.getValue(catalogueRepository.getTvShowById(tvShowId))
        verify(local).getTvShowById(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.value, tvShowEntity)
    }

    @Test
    fun setFavoriteMovie() {
        val dummyMovie = DataDummy.generateDummyMovies()[0]
        val newState = !dummyMovie.isFavorite

        `when`(appExecutors.diskIO()).thenReturn(testExecutor.diskIO())
        doNothing().`when`(local).setFavoriteMovie(dummyMovie, newState)

        catalogueRepository.setFavoriteMovie(dummyMovie, newState)
        verify(local).setFavoriteMovie(dummyMovie, newState)
    }

    @Test
    fun setUnfavoredMovie() {
        val dummyMovie = DataDummy.generateDummyMovies()[0].copy(isFavorite = true)
        val newState = !dummyMovie.isFavorite

        `when`(appExecutors.diskIO()).thenReturn(testExecutor.diskIO())
        doNothing().`when`(local).setFavoriteMovie(dummyMovie, newState)

        catalogueRepository.setFavoriteMovie(dummyMovie, newState)
        verify(local).setFavoriteMovie(dummyMovie, newState)
    }

    @Test
    fun setFavoriteTvShow() {
        val dummyTvShow = DataDummy.generateDummyTvShows()[0]
        val newState = !dummyTvShow.isFavorite

        `when`(appExecutors.diskIO()).thenReturn(testExecutor.diskIO())
        doNothing().`when`(local).setFavoriteTvShow(dummyTvShow, newState)

        catalogueRepository.setFavoriteTvShow(dummyTvShow, newState)
        verify(local).setFavoriteTvShow(dummyTvShow, newState)
    }

    @Test
    fun setUnfavoredTvShow() {
        val dummyTvShow = DataDummy.generateDummyTvShows()[0].copy(isFavorite = true)
        val newState = !dummyTvShow.isFavorite

        `when`(appExecutors.diskIO()).thenReturn(testExecutor.diskIO())
        doNothing().`when`(local).setFavoriteTvShow(dummyTvShow, newState)

        catalogueRepository.setFavoriteTvShow(dummyTvShow, newState)
        verify(local).setFavoriteTvShow(dummyTvShow, newState)
    }
}