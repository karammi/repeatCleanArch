package co.baron.data

import co.baron.data.mapper.ProjectMapper
import co.baron.data.repository.ProjectsCache
import co.baron.data.store.ProjectsDataStoreFactory
import co.baron.domain.model.Project
import co.baron.domain.repository.ProjectsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

/**
 * Created by asad on 11/03/19.
 */
class ProjectsDataRepository @Inject constructor(
        private val mapper: ProjectMapper,
        private val cache: ProjectsCache,
        private val factory: ProjectsDataStoreFactory) : ProjectsRepository {


    override fun getProjects(): Observable<List<Project>> {

        return Observable.zip(
                cache.areProjectsCached().toObservable(),
                cache.isProjectsCacheExpired().toObservable(),
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { cached, expired ->
                    Pair(cached, expired)
                }).flatMap {
            factory.getDataStore(it.first, it.second)
                    .getProjects()
                    .distinctUntilChanged()
                    .toObservable()
        }.flatMap { projects ->
            factory.getCacheDataStore()
                    .saveProjects(projects)
                    .andThen(
                            factory.getCacheDataStore()
                                    .getProjects().toObservable()
                    )
        }.map { list -> list.map { mapper.mapFromEntity(it) } }


//        return Observable.zip(
//                cache.areProjectsCached().toObservable(),
//                cache.isProjectsCacheExpired().toObservable(),
//                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { cached, expired ->
//                    Pair(cached, expired)
//                }).flatMap {
//            factory.getDataStore(it.first, it.second)
//                    .getProjects()
//                    .toObservable()
//                    .distinctUntilChanged()
//        }.flatMap { projects ->
//            factory.getCacheDataStore()
//                    .saveProjects(projects)
//                    .andThen(
//                            factory.getCacheDataStore()
//                                    .getProjects()
//                                    .toObservable()
//                    )
//        }.map { list -> list.map { mapper.mapFromEntity(it) } }
    }


    override fun bookmarkedProject(projectId: String): Completable {
        return factory.getCacheDataStore().setProjectAsBookmarked(projectId)
    }

    override fun unBookmarkedProject(projectId: String): Completable {
        return factory.getCacheDataStore().setProjectAsNotBookmarked(projectId)
    }

    override fun getBookmarkedProjects(): Observable<List<Project>> {
        return factory.getCacheDataStore().getBookmarkedProjects()
                .map { it.map { mapper.mapFromEntity(it) } }
    }
}