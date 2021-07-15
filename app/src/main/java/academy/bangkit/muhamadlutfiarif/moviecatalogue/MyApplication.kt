package academy.bangkit.muhamadlutfiarif.moviecatalogue

import academy.bangkit.muhamadlutfiarif.core.di.CoreComponent
import academy.bangkit.muhamadlutfiarif.core.di.DaggerCoreComponent
import academy.bangkit.muhamadlutfiarif.moviecatalogue.di.AppComponent
import academy.bangkit.muhamadlutfiarif.moviecatalogue.di.DaggerAppComponent
import android.app.Application

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}