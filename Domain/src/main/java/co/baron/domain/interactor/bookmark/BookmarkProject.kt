package co.baron.domain.interactor.bookmark

import co.baron.domain.executor.PostExecutionThread
import co.baron.domain.interactor.CompletableUseCase
import co.baron.domain.repository.ProjectsRepository
import io.reactivex.Completable
import javax.inject.Inject


class BookmarkProject @Inject constructor(private val projectsRepository: ProjectsRepository,
                                          postExecutionThread: PostExecutionThread) :
        CompletableUseCase<BookmarkProject.Params>(postExecutionThread) {


    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.bookmarkedProject(params.projectId)
    }

    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String): Params {
                return Params(projectId)
            }
        }
    }
}