package co.baron.domain.repository

import co.baron.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Observable

interface ProjectsRepository {

    fun getProjects(): Observable<List<Project>>

    fun bookmarkedProject(projectId: String): Completable

    fun unBookmarkedProject(projectId: String): Completable

    fun getBookmarkedProjects(): Observable<List<Project>>
}