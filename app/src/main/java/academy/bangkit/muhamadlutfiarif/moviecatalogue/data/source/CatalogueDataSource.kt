package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity

interface CatalogueDataSource {

    fun getMovies(): List<CatalogueEntity>

    fun getTvShows(): List<CatalogueEntity>
}