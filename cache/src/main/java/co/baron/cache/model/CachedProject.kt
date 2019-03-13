package co.baron.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.baron.cache.db.ProjectConstant

/**
 * Created by asad on 12/03/19.
 */
@Entity(tableName = ProjectConstant.TABLE_NAME)
data class CachedProject(
        @PrimaryKey
        @ColumnInfo(name = ProjectConstant.COLUMN_PROJECT_ID)
        var id: String,
        var name: String,
        var fullName: String,
        var starCount: String,
        var dateCreated: String,
        var ownerName: String,
        var ownerAvatar: String,
        @ColumnInfo(name = ProjectConstant.COLUMN_IS_BOOKMARKED)
        var isBookmarked: Boolean
)