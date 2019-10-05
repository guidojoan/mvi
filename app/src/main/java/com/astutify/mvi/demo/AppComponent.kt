package com.astutify.mvi.demo

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}
