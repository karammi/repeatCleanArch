package co.baron.remote

import co.baron.data.model.ProjectEntity
import co.baron.data.repository.ProjectsRemote
import co.baron.remote.mapper.ProjectsRepsonseModelMapper
import co.baron.remote.service.GithubTrendingService
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by asad on 12/03/19.
 */
class ProjectsRemoteImp @Inject constructor(
        private val service: GithubTrendingService,
        private val mapper: ProjectsRepsonseModelMapper) : ProjectsRemote {


    override fun getProjects(): Flowable<List<ProjectEntity>> {
        return return service.searchRepositories("language:kotlin", "stars", "desc")
                .map {
                    it.items.map { mapper.mapFromModel(it) }
//                    response -> response.items.map { mapper.mapFromModel(it) }
                }
    }
}