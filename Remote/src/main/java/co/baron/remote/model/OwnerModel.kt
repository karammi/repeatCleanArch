package co.baron.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by asad on 12/03/19.
 */
class OwnerModel(@SerializedName("login") val ownerName: String,
                 @SerializedName("avatar_url") val ownerAvatar: String)