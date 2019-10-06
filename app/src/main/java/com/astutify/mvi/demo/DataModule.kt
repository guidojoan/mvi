package com.astutify.mvi.demo

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.Date
import java.util.concurrent.TimeUnit

@Module
class DataModule {

    @Provides
    fun providesOkHttp(): OkHttpClient {

        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder {

        val moshiBuilder = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())

        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER)
            .addConverterFactory(MoshiConverterFactory.create(moshiBuilder.build()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
    }

    @Provides
    fun retrofitNoAuth(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient): Retrofit {
        return retrofitBuilder
            .client(okHttpClient)
            .build()
    }
}
