package co.baron.data.mapper

import co.baron.data.model.ProjectEntity
import co.baron.domain.model.Project
import javax.inject.Inject

/**
 * Created by asad on 11/03/19.
 */
class ProjectMapper @Inject constructor() : EntityMapper<ProjectEntity, Project> {

    override fun mapFromEntity(entity: ProjectEntity): Project {
        return Project(entity.id,
                entity.name,
                entity.fullName,
                entity.starCount,
                entity.dateCreated,
                entity.ownerName,
                entity.ownerAvatar,
                entity.isBookmarked)
    }

    override fun mapToEntity(domain: Project): ProjectEntity {
        return ProjectEntity(domain.id,
                domain.name,
                domain.fullName,
                domain.startCount,
                domain.dateCreated,
                domain.ownerName,
                domain.ownerAvatar,
                domain.isBookmarked)
    }
}