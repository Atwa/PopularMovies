package ahmed.atwa.popularmovies.di.component

import ahmed.atwa.popularmovies.PopMovApp
import ahmed.atwa.popularmovies.di.builder.ActivityBuilder
import ahmed.atwa.popularmovies.di.module.*
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Ahmed Atwa on 10/19/18.
 */

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (DbModule::class),
    (NetworkModule::class), (RepoModule::class), (ActivityBuilder::class)])

interface AppComponent {

    fun inject(app: PopMovApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}