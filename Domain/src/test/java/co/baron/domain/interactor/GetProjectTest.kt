package co.baron.domain.interactor

import co.baron.domain.executor.PostExecutionThread
import co.baron.domain.interactor.browse.GetProjects
import co.baron.domain.model.Project
import co.baron.domain.repository.ProjectsRepository
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by asad on 10/03/19.
 */
class GetProjectTest {
    private lateinit var getProjects: GetProjects
    @Mock
    lateinit var projectsRepository: ProjectsRepository
    @Mock
    lateinit var postExecutionThread: PostExecutionThread


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getProjects = GetProjects(projectsRepository, postExecutionThread)
    }

    @Test
    fun getProjectsCompletes() {

    }

    private fun stubGetProjects(observable: Observable<List<Project>>){
        whenever(projectsRepository.getProjects())
                .thenReturn(observable)
    }
}