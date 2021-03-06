package co.baron.remote.service

import co.baron.remote.model.ProjectsResponseModel
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by asad on 12/03/19.
 */
interface GithubTrendingService {

    @GET("search/repositories")
    fun searchRepositories(
            @Query("q") query: String,
            @Query("sort") sortBy: String,
            @Query("order") order: String): Flowable<ProjectsResponseModel>
}