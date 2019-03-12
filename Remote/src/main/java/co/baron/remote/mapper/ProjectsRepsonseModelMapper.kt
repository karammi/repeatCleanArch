package co.baron.remote.mapper

import co.baron.data.model.ProjectEntity
import co.baron.remote.model.ProjectModel

/**
 * Created by asad on 12/03/19.
 */
class ProjectsRepsonseModelMapper : ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name,
                model.fullName, model.starCount.toString(),
                model.dateCreated, model.owner.ownerName,
                model.owner.ownerAvatar, false)
    }
}