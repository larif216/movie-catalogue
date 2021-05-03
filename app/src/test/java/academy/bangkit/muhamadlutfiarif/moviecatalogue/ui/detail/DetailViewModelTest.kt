package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.detail

import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyCatalogue = DataDummy.generateDummyMovies()[0]
    private val catalogueId = dummyCatalogue.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setCatalogueDetail(catalogueId, DetailViewModel.TYPE_MOVIE)
    }

    @Test
    fun getCatalogueDetail() {
        val catalogue = viewModel.getCatalogueDetail()
        assertNotNull(catalogue)
        assertEquals(catalogue.id, dummyCatalogue.id)
        assertEquals(catalogue.title, dummyCatalogue.title)
        assertEquals(catalogue.releaseDate, dummyCatalogue.releaseDate)
        assertEquals(catalogue.duration, dummyCatalogue.duration)
        assertEquals(catalogue.userScore, dummyCatalogue.userScore)
        assertEquals(catalogue.genre, dummyCatalogue.genre)
        assertEquals(catalogue.overview, dummyCatalogue.overview)
        assertEquals(catalogue.poster, dummyCatalogue.poster)
    }
}