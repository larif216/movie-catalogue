package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.usecase

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.model.TvShow
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.domain.repository.ICatalogueRepository

class CatalogueInteractor(private val catalogueRepository: ICatalogueRepository): CatalogueUseCase {
    override fun getMovies() = catalogueRepository.getMovies()

    override fun getTvShows() = catalogueRepository.getTvShows()

    override fun getFavoriteMovies() = catalogueRepository.getFavoriteMovies()

    override fun getFavoriteTvShows() = catalogueRepository.getFavoriteTvShows()

    override fun getMovieById(id: Int) = catalogueRepository.getMovieById(id)

    override fun getTvShowById(id: Int) = catalogueRepository.getTvShowById(id)

    override fun setFavoriteMovie(movie: Movie, newState: Boolean) = catalogueRepository.setFavoriteMovie(movie, newState)

    override fun setFavoriteTvShow(tvShow: TvShow, newState: Boolean) = catalogueRepository.setFavoriteTvShow(tvShow, newState)

}