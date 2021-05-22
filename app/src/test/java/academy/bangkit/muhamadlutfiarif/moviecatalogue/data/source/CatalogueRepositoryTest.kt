package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote.RemoteDataSource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.FakeCatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.LiveDataTestUtil
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class CatalogueRepositoryTest {

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val movieResponses = DataDummy.generateDummyMoviesResponse()
    private val tvShowResponses = DataDummy.generateDummyTvShowsResponse()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getMovies() {
        `when`(remote.getMovies()).thenReturn(movieResponses)
        val movies = LiveDataTestUtil.getValue(catalogueRepository.getMovies())
        verify(remote).getMovies()
        assertNotNull(movies)
        assertEquals(movieResponses.size, movies.size)
    }

    @Test
    fun getTvShows() {
        `when`(remote.getTvShows()).thenReturn(tvShowResponses)
        val tvShows = LiveDataTestUtil.getValue(catalogueRepository.getTvShows())
        verify(remote).getTvShows()
        assertNotNull(tvShows)
        assertEquals(movieResponses.size, tvShows.size)
    }
}