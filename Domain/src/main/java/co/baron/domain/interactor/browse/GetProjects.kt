package co.baron.domain.interactor.browse

import co.baron.domain.executor.PostExecutionThread
import co.baron.domain.interactor.ObservableUseCase
import co.baron.domain.model.Project
import co.baron.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject


class GetProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getProjects()
    }
}