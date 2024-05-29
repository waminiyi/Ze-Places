package com.waminiyi.zeplaces.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.waminiyi.zeplaces.data.cache.room.RoomPlacesDatabase
import com.waminiyi.zeplaces.data.cache.room.SavedPlacesDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDatasourceModule = module {
    single { provideRemDatabase(androidContext()) }
    single { provideEstateDao(get()) }
}

/**
 * Provides an instance of [RoomPlacesDatabase] using the given [context].
 *
 * @param context The context used to create the database.
 * @return An instance of [RoomPlacesDatabase].
 */
fun provideRemDatabase(context: Context): RoomPlacesDatabase {
    return Room.databaseBuilder(
        context,
        RoomPlacesDatabase::class.java,
        "ZePlacesDatabase"
    ).addCallback(object : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            db.execSQL("PRAGMA foreign_keys=ON;")
        }
    }).setQueryCallback(
        { sql, bindArgs -> Log.d("RoomSQL", "Query: $sql, BindArgs: $bindArgs") },
        { command -> command.run() }
    ).build()
}

/**
 * Provides an instance of [SavedPlacesDao] by accessing it from the provided [database].
 *
 * @param database The Room database instance.
 * @return An instance of [SavedPlacesDao].
 */
fun provideEstateDao(database: RoomPlacesDatabase): SavedPlacesDao {
    return database.savedPlacesDao()
}
