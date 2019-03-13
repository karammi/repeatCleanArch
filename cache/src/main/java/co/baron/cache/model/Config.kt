package co.baron.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.baron.cache.db.ConfigConstants

/**
 * Created by asad on 13/03/19.
 */
@Entity(tableName = ConfigConstants.TABLE_NAME)
data class Config(
        @PrimaryKey(autoGenerate = true)
        var id: Int = -1,
        val lastCacheTime: Long
)