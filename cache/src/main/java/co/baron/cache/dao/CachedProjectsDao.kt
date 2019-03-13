package co.baron.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.baron.cache.db.ProjectConstant
import co.baron.cache.model.CachedProject
import io.reactivex.Flowable

/**
 * Created by asad on 12/03/19.
 */
@Dao
abstract class CachedProjectsDao {

    @Query(ProjectConstant.QUERY_PROJECTS)
    abstract fun getProjects(): Flowable<List<CachedProject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProjects(projects: List<CachedProject>)

    @Query(ProjectConstant.DELETE_PROJECTS)
    abstract fun deleteProjects()

    @Query(ProjectConstant.QUERY_BOOKMARKED_PROJECTS)
    abstract fun getBookamrkedProjects(): Flowable<List<CachedProject>>


    @Query(ProjectConstant.QUERY_UPDATE_BOOKMARK_STATUS)
    abstract fun setBookmarkStatus(isBookmarked: Boolean,
                                   projectId: String)
}