package co.baron.data.store

import co.baron.data.repository.ProjectDataStore
import javax.inject.Inject

/**
 * Created by asad on 11/03/19.
 */
class ProjectsDataStoreFactory @Inject constructor(
        private val projectsCacheDataStore: ProjectsCacheDataStore,
        private val projectsRemoteDataStore: ProjectsRemoteDataStore) {

    open fun getDataStore(projectCached: Boolean,
                          cacheExpired: Boolean): ProjectDataStore {
        return if (projectCached && !cacheExpired) {
            projectsCacheDataStore
        } else {
            projectsRemoteDataStore
        }
    }

    fun getCacheDataStore(): ProjectDataStore {
        return projectsCacheDataStore
    }
}