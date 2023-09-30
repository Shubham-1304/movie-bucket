package com.example.test_app.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.test_app.data.MovieDatabase
import com.example.test_app.data.MovieRepository
import com.example.test_app.data.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): MovieDatabase {
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE movie_temp (id TEXT NOT NULL, title TEXT NOT NULL, rating REAL NULL,userRating INTEGER NOT NULL,isWatched INTEGER NOT NULL,PRIMARY KEY(id))"
                )
                database.execSQL("DROP TABLE movie")
                database.execSQL("ALTER TABLE movie_temp RENAME TO movie")
            }
        }
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "todo_db"
        ).addMigrations(MIGRATION_1_2).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: MovieDatabase): MovieRepository {
        return MovieRepositoryImpl(db.dao)
    }

}