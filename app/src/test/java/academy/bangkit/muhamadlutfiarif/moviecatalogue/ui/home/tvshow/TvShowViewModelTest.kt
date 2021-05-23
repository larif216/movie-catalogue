package academy.bangkit.muhamadlutfiarif.moviecatalogue.ui.home.tvshow

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.CatalogueRepository
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.utils.DataDummy
import academy.bangkit.muhamadlutfiarif.moviecatalogue.vo.Resource
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.doNothing
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel
    private val dummyTvShows = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShows.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var observerFavorite: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var observerDetail: Observer<TvShowEntity>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = Resource.success(pagedList)
        `when`(dummyTvShow.data?.size).thenReturn(5)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShow

        `when`(catalogueRepository.getTvShows()).thenReturn(tvShows)
        val tvShowsEntities = viewModel.getTvShows().value?.data
        verify(catalogueRepository).getTvShows()
        assertNotNull(tvShowsEntities)
        assertEquals(5, tvShowsEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }

    @Test
    fun getFavoriteTvShows() {
        val dummyFavoriteTvShows = pagedList
        `when`(dummyFavoriteTvShows.size).thenReturn(5)
        val favoriteTvShows = MutableLiveData<PagedList<TvShowEntity>>()
        favoriteTvShows.value = dummyFavoriteTvShows

        `when`(catalogueRepository.getFavoriteTvShows()).thenReturn(favoriteTvShows)
        val favoriteTvShowEntities = viewModel.getFavoriteTvShows().value
        verify(catalogueRepository).getFavoriteTvShows()
        assertNotNull(favoriteTvShowEntities)
        assertEquals(5, favoriteTvShowEntities?.size)

        viewModel.getFavoriteTvShows().observeForever(observerFavorite)
        verify(observerFavorite).onChanged(dummyFavoriteTvShows)
    }

    @Test
    fun `setSelectedTvShow should be success`() {
        val expected = MutableLiveData<TvShowEntity>()
        expected.value = DataDummy.generateDummyTvShows()[0]

        `when`(catalogueRepository.getTvShowById(tvShowId)).thenReturn(expected)

        viewModel.tvShowDetail.observeForever(observerDetail)

        verify(observerDetail).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.tvShowDetail.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setFavorite() should be success trigger tvShowDetail observer`() {
        val expected = MutableLiveData<TvShowEntity>()
        expected.value = DataDummy.generateDummyTvShows()[0]

        `when`(catalogueRepository.getTvShowById(tvShowId)).thenReturn(expected)

        viewModel.setFavorite()
        viewModel.tvShowDetail.observeForever(observerDetail)

        verify(observerDetail).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.tvShowDetail.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun testSetFavorite() {
        val dummyTvShow = DataDummy.generateDummyTvShows()[0]
        val tvShowEntity = MutableLiveData<TvShowEntity>()
        tvShowEntity.value = dummyTvShow
        tvShowEntity.value?.isFavorite = false

        `when`(catalogueRepository.getTvShowById(tvShowId)).thenReturn(tvShowEntity)
        viewModel.tvShowDetail.observeForever(observerDetail)

        doNothing().`when`(catalogueRepository).setFavoriteTvShow(dummyTvShow, !dummyTvShow.isFavorite)
        viewModel.setFavorite()
        verify(catalogueRepository).setFavoriteTvShow(dummyTvShow, !dummyTvShow.isFavorite)
    }

    @Test
    fun testSetUnfavored() {
        val dummyTvShow = DataDummy.generateDummyTvShows()[0]
        val tvShowEntity = MutableLiveData<TvShowEntity>()
        tvShowEntity.value = dummyTvShow
        tvShowEntity.value?.isFavorite = true

        `when`(catalogueRepository.getTvShowById(tvShowId)).thenReturn(tvShowEntity)
        viewModel.tvShowDetail.observeForever(observerDetail)

        doNothing().`when`(catalogueRepository).setFavoriteTvShow(dummyTvShow, !dummyTvShow.isFavorite)
        viewModel.setFavorite()
        verify(catalogueRepository).setFavoriteTvShow(dummyTvShow, !dummyTvShow.isFavorite)
    }
}