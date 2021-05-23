package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.movie

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import academy.bangkit.muhamadlutfiarif.moviecatalogue.vo.Resource
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.doNothing
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovies.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var observerFavorite: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerDetail: Observer<MovieEntity>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogueRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value?.data
        verify(catalogueRepository).getMovies()
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavoriteMovies = pagedList
        `when`(dummyFavoriteMovies.size).thenReturn(5)
        val favoriteMovies = MutableLiveData<PagedList<MovieEntity>>()
        favoriteMovies.value = dummyFavoriteMovies

        `when`(catalogueRepository.getFavoriteMovies()).thenReturn(favoriteMovies)
        val favoriteMovieEntities = viewModel.getFavoriteMovies().value
        verify(catalogueRepository).getFavoriteMovies()
        assertNotNull(favoriteMovieEntities)
        assertEquals(5, favoriteMovieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observerFavorite)
        verify(observerFavorite).onChanged(dummyFavoriteMovies)
    }

    @Test
    fun `setSelectedMovie should be success`() {
        val expected = MutableLiveData<MovieEntity>()
        expected.value = DataDummy.generateDummyMovies()[0]

        `when`(catalogueRepository.getMovieById(movieId)).thenReturn(expected)

        viewModel.movieDetail.observeForever(observerDetail)

        verify(observerDetail).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.movieDetail.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setFavorite() should be success trigger movieDetail observer`() {
        val expected = MutableLiveData<MovieEntity>()
        expected.value = DataDummy.generateDummyMovies()[0]

        `when`(catalogueRepository.getMovieById(movieId)).thenReturn(expected)

        viewModel.setFavorite()
        viewModel.movieDetail.observeForever(observerDetail)

        verify(observerDetail).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.movieDetail.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun testSetFavorite() {
        val dummyMovie = DataDummy.generateDummyMovies()[0]
        val movieEntity = MutableLiveData<MovieEntity>()
        movieEntity.value = dummyMovie
        movieEntity.value?.isFavorite = false

        `when`(catalogueRepository.getMovieById(movieId)).thenReturn(movieEntity)
        viewModel.movieDetail.observeForever(observerDetail)

        doNothing().`when`(catalogueRepository).setFavoriteMovie(dummyMovie, !dummyMovie.isFavorite)
        viewModel.setFavorite()
        verify(catalogueRepository).setFavoriteMovie(dummyMovie, !dummyMovie.isFavorite)
    }

    @Test
    fun testSetUnfavored() {
        val dummyMovie = DataDummy.generateDummyMovies()[0]
        val movieEntity = MutableLiveData<MovieEntity>()
        movieEntity.value = dummyMovie
        movieEntity.value?.isFavorite = true

        `when`(catalogueRepository.getMovieById(movieId)).thenReturn(movieEntity)
        viewModel.movieDetail.observeForever(observerDetail)

        doNothing().`when`(catalogueRepository).setFavoriteMovie(dummyMovie, !dummyMovie.isFavorite)
        viewModel.setFavorite()
        verify(catalogueRepository).setFavoriteMovie(dummyMovie, !dummyMovie.isFavorite)
    }
}