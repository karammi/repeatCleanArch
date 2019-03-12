package co.baron.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by asad on 12/03/19.
 */
class ProjectModel(val id: String, val name: String,
                   @SerializedName("full_name") val fullName: String,
                   @SerializedName("stargazers_count") val starCount: Int,
                   @SerializedName("created_at") val dateCreated: String,
                   val owner: OwnerModel)