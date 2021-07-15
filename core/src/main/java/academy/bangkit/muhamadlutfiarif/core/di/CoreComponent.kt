package academy.bangkit.muhamadlutfiarif.core.di

import academy.bangkit.muhamadlutfiarif.core.domain.repository.ICatalogueRepository
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): ICatalogueRepository
}