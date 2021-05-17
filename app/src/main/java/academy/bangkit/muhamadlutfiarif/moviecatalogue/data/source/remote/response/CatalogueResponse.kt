package academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.remote.response

import academy.bangkit.muhamadlutfiarif.moviecatalogue.data.source.local.entity.CatalogueEntity
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatalogueResponse(
        var list: List<CatalogueEntity>
): Parcelable
