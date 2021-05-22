package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.MovieEntity
import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.TvShowEntity
import androidx.lifecycle.LiveData

interface CatalogueDataSource {

    fun getMovies(): LiveData<List<MovieEntity>>

    fun getTvShows(): LiveData<List<TvShowEntity>>
}