package academy.bangkit.muhamadlutfiarif.moviecatalogue.utils

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    companion object {
        const val FILE_MOVIE = "MovieResponse.json"
        const val FILE_TV_SHOW = "TvShowResponse.json"
    }
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadCatalogue(fileName: String): List<CatalogueEntity> {
        val list = ArrayList<CatalogueEntity>()
        try {
            val responseObject = JSONObject(parsingFileToString(fileName).toString())
            val listArray = responseObject.getJSONArray("list")
            for (i in 0 until listArray.length()) {
                val item = listArray.getJSONObject(i)

                val id = item.getString("id")
                val title = item.getString("title")
                val releaseDate = item.getString("releaseDate")
                val genre = item.getString("genre")
                val duration = item.getString("duration")
                val userScore = item.getString("userScore")
                val overview = item.getString("overview")
                val poster = item.getString("poster")

                val catalogue = CatalogueEntity(
                        id.toInt(),
                        title,
                        releaseDate,
                        genre,
                        duration,
                        userScore,
                        overview,
                        poster
                )
                list.add(catalogue)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}