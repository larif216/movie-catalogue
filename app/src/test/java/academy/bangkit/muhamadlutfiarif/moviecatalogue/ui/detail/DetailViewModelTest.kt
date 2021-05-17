package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyCatalogue = DataDummy.generateDummyMovies()[0]
    private val catalogueId = dummyCatalogue.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<CatalogueEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getCatalogueDetail() {
        val dummyMovies = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<CatalogueEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getMovies()).thenReturn(movies)
        viewModel.setCatalogueDetail(catalogueId, DetailViewModel.TYPE_MOVIE)
        val catalogue = viewModel.selectedCatalogue
        assertNotNull(catalogue)
        assertEquals(catalogue.value?.id, dummyCatalogue.id)
        assertEquals(catalogue.value?.title, dummyCatalogue.title)
        assertEquals(catalogue.value?.releaseDate, dummyCatalogue.releaseDate)
        assertEquals(catalogue.value?.duration, dummyCatalogue.duration)
        assertEquals(catalogue.value?.userScore, dummyCatalogue.userScore)
        assertEquals(catalogue.value?.genre, dummyCatalogue.genre)
        assertEquals(catalogue.value?.overview, dummyCatalogue.overview)
        assertEquals(catalogue.value?.poster, dummyCatalogue.poster)

        viewModel.selectedCatalogue.observeForever(observer)
        verify(observer).onChanged(dummyCatalogue)
    }
}