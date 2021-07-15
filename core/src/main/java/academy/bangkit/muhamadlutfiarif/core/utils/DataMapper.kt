package academy.bangkit.muhamadlutfiarif.core.utils

import academy.bangkit.muhamadlutfiarif.core.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.core.data.source.local.entity.TvShowEntity
import academy.bangkit.muhamadlutfiarif.core.data.source.remote.response.MovieResponse
import academy.bangkit.muhamadlutfiarif.core.data.source.remote.response.TvShowResponse
import academy.bangkit.muhamadlutfiarif.core.domain.model.Movie
import academy.bangkit.muhamadlutfiarif.core.domain.model.TvShow

object DataMapper {
    fun mapMovieResponseToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                userScore = it.userScore.toString(),
                overview = it.overview,
                poster = it.poster,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapTvShowResponseToEntities(input: List<TvShowResponse>): List<TvShowEntity> {
        val tvShowList = ArrayList<TvShowEntity>()
        input.map {
            val tvShow = TvShowEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                userScore = it.userScore.toString(),
                overview = it.overview,
                poster = it.poster,
                isFavorite = false
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    fun mapMovieEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                userScore = it.userScore,
                overview = it.overview,
                poster = it.poster,
                isFavorite = it.isFavorite
            )
        }

    fun mapTvShowEntitiesToDomain(input: List<TvShowEntity>): List<TvShow> =
        input.map {
            TvShow(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                userScore = it.userScore,
                overview = it.overview,
                poster = it.poster,
                isFavorite = it.isFavorite
            )
        }

    fun mapMovieEntityToDomain(input: MovieEntity) = Movie(
        id = input.id,
        title = input.title,
        releaseDate = input.releaseDate,
        userScore = input.userScore,
        overview = input.overview,
        poster = input.poster,
        isFavorite = input.isFavorite
    )

    fun mapTvShowEntityToDomain(input: TvShowEntity) = TvShow(
        id = input.id,
        title = input.title,
        releaseDate = input.releaseDate,
        userScore = input.userScore,
        overview = input.overview,
        poster = input.poster,
        isFavorite = input.isFavorite
    )


    fun mapMovieDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        title = input.title,
        releaseDate = input.releaseDate,
        userScore = input.userScore,
        overview = input.overview,
        poster = input.poster,
        isFavorite = input.isFavorite
    )

    fun mapTvShowDomainToEntity(input: TvShow) = TvShowEntity(
        id = input.id,
        title = input.title,
        releaseDate = input.releaseDate,
        userScore = input.userScore,
        overview = input.overview,
        poster = input.poster,
        isFavorite = input.isFavorite
    )
}