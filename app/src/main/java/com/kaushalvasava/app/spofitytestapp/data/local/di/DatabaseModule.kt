package com.kaushalvasava.app.spofitytestapp.data.local.di

import android.app.Application
import androidx.room.Room
import com.kaushalvasava.app.spofitytestapp.data.local.HistoryDatabase
import com.kaushalvasava.app.spofitytestapp.data.local.repo.HistoryRepo
import com.kaushalvasava.app.spofitytestapp.data.local.repo.HistoryRepoImpl
import com.kaushalvasava.app.spofitytestapp.data.local.util.DatabaseConstant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideHistoryDatabase(app: Application): HistoryDatabase {
        return Room.databaseBuilder(
            app,
            HistoryDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideHistoryRepository(db: HistoryDatabase): HistoryRepo {
        return HistoryRepoImpl(db.historyDao)
    }
}