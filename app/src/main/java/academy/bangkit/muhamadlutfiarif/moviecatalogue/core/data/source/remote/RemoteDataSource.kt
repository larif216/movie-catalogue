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
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
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

    fun getMovies(): Flowable<ApiResponse<List<MovieResponse>>> {
        val resultMovies = PublishSubject.create<ApiResponse<List<MovieResponse>>>()
        val client = apiService.getMovies(API_KEY)
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataArray = response.movies
                resultMovies.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultMovies.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })
        return resultMovies.toFlowable(BackpressureStrategy.BUFFER)
    }

    fun getTvShows(): Flowable<ApiResponse<List<TvShowResponse>>> {
        val resultTvShows = PublishSubject.create<ApiResponse<List<TvShowResponse>>>()
        val client = apiService.getTvShows(API_KEY)
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataArray = response.tvShows
                resultTvShows.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultTvShows.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })
        return resultTvShows.toFlowable(BackpressureStrategy.BUFFER)
    }
}