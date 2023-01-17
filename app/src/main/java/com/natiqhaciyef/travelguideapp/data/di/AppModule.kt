package com.natiqhaciyef.travelguideapp.data.di

import android.content.Context
import androidx.room.Room
import com.natiqhaciyef.travelguideapp.data.repository.AppTicketRepository
import com.natiqhaciyef.travelguideapp.data.repository.AppUserRepository
import com.natiqhaciyef.travelguideapp.data.room.AppDao
import com.natiqhaciyef.travelguideapp.data.room.AppDatabase
import com.natiqhaciyef.travelguideapp.data.source.AppDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
//            .fallbackToDestructiveMigration()
            .build().getDao()

    @Provides
    @Singleton
    fun provideDataSource(dao: AppDao) = AppDataSource(dao)

    @Provides
    @Singleton
    fun provideTicketRepository(ds: AppDataSource) = AppTicketRepository(ds)

    @Provides
    @Singleton
    fun provideUserRepository(ds: AppDataSource) = AppUserRepository(ds)

}