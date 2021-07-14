package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.network

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.MovieListResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.TvShowListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") api_key: String): Call<MovieListResponse>

    @GET("tv/popular")
    fun getTvShows(@Query("api_key") api_key: String): Call<TvShowListResponse>
}