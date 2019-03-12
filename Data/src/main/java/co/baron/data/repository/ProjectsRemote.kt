package co.baron.data.repository

import co.baron.data.model.ProjectEntity
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by asad on 11/03/19.
 */
interface ProjectsRemote {

//    fun getProjects(): Observable<List<ProjectEntity>>
    fun getProjects(): Flowable<List<ProjectEntity>>
}