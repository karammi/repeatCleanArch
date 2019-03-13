package co.baron.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.baron.cache.dao.CachedProjectsDao
import co.baron.cache.dao.ConfigDao
import co.baron.cache.model.CachedProject
import co.baron.cache.model.Config
import co.baron.cache.model.SingletonHolder

/**
 * Created by asad on 13/03/19.
 */
@Database(
        entities = [
            CachedProject::class,
            Config::class],
        version = 1,
        exportSchema = false)
abstract class ProjectsDatabase : RoomDatabase() {

    abstract fun cachedProjectsDao(): CachedProjectsDao

    abstract fun configDao(): ConfigDao

    companion object : SingletonHolder<Context, ProjectsDatabase>({
        Room.databaseBuilder(
                it.applicationContext,
                ProjectsDatabase::class.java,
                "projects.db"
        ).build()
    })
}