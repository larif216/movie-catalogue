package academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote

import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.network.ApiResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.network.ApiService
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.MovieListResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.MovieResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.TvShowListResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.data.source.remote.response.TvShowResponse
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.EspressoIdlingResource
import academy.bangkit.muhamadlutfiarif.moviecatalogue.core.utils.JsonHelper
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val API_KEY = "e1e356b84f47af3956862199b4b2b899"
        const val IMAGE_DOMAIN = "https://image.tmdb.org/t/p/w500/"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(service).apply { instance = this }
                }
    }

    fun getMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        val client = apiService.getMovies(API_KEY)
        client.enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>
            ) {
                val dataArray = response.body()?.movies
                resultMovies.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                resultMovies.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })
        return resultMovies
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        val client = apiService.getTvShows(API_KEY)
        client.enqueue(object : Callback<TvShowListResponse> {
            override fun onResponse(
                call: Call<TvShowListResponse>,
                response: Response<TvShowListResponse>
            ) {
                val dataArray = response.body()?.tvShows
                resultTvShows.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<TvShowListResponse>, t: Throwable) {
                resultTvShows.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })
        return resultTvShows
    }
}