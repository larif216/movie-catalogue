package academy.bangkit.muhamadlutfiarif.core.utils

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

//    companion object {
//        const val FILE_MOVIE = "MovieResponse.json"
//        const val FILE_TV_SHOW = "TvShowResponse.json"
//    }
//    private fun parsingFileToString(fileName: String): String? {
//        return try {
//            val `is` = context.assets.open(fileName)
//            val buffer = ByteArray(`is`.available())
//            `is`.read(buffer)
//            `is`.close()
//            String(buffer)
//
//        } catch (ex: IOException) {
//            ex.printStackTrace()
//            null
//        }
//    }
//
//    fun loadMovies(fileName: String): List<MovieResponse> {
//        val list = ArrayList<MovieResponse>()
//        try {
//            val responseObject = JSONObject(parsingFileToString(fileName).toString())
//            val listArray = responseObject.getJSONArray("list")
//            for (i in 0 until listArray.length()) {
//                val item = listArray.getJSONObject(i)
//
//                val id = item.getString("id")
//                val title = item.getString("title")
//                val releaseDate = item.getString("releaseDate")
//                val genre = item.getString("genre")
//                val duration = item.getString("duration")
//                val userScore = item.getString("userScore")
//                val overview = item.getString("overview")
//                val poster = item.getString("poster")
//
//                val movie = MovieResponse(
//                        id.toInt(),
//                        title,
//                        releaseDate,
//                        genre,
//                        duration,
//                        userScore,
//                        overview,
//                        poster
//                )
//                list.add(movie)
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return list
//    }
//
//    fun loadTvShows(fileName: String): List<TvShowResponse> {
//        val list = ArrayList<TvShowResponse>()
//        try {
//            val responseObject = JSONObject(parsingFileToString(fileName).toString())
//            val listArray = responseObject.getJSONArray("list")
//            for (i in 0 until listArray.length()) {
//                val item = listArray.getJSONObject(i)
//
//                val id = item.getString("id")
//                val title = item.getString("title")
//                val releaseDate = item.getString("releaseDate")
//                val genre = item.getString("genre")
//                val duration = item.getString("duration")
//                val userScore = item.getString("userScore")
//                val overview = item.getString("overview")
//                val poster = item.getString("poster")
//
//                val tvShow = TvShowResponse(
//                        id.toInt(),
//                        title,
//                        releaseDate,
//                        genre,
//                        duration,
//                        userScore,
//                        overview,
//                        poster
//                )
//                list.add(tvShow)
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        return list
//    }
}