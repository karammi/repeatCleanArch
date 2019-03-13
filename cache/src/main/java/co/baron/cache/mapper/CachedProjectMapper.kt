package co.baron.cache.mapper

import co.baron.cache.model.CachedProject
import co.baron.data.model.ProjectEntity

/**
 * Created by asad on 13/03/19.
 */
class CachedProjectMapper : CacheMapper<CachedProject, ProjectEntity> {
    override fun mapFromCached(type: CachedProject): ProjectEntity {
        return ProjectEntity(type.id, type.name,
                type.fullName, type.starCount,
                type.dateCreated, type.ownerName,
                type.ownerAvatar, type.isBookmarked)
    }

    override fun mapToCached(type: ProjectEntity): CachedProject {
        return CachedProject(type.id, type.name,
                type.fullName, type.starCount,
                type.dateCreated, type.ownerName,
                type.ownerAvatar, type.isBookmarked)
    }
}