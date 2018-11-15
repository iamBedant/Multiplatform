package sample

import kotlinx.serialization.*

/**
 * Created by @iamBedant on 13/11/18.
 */


@Serializable
data class AllData(
    val name: String = "",
    val avatar_url: String="",
    val public_repos: Int = 0
)

class SessionizeData(val allData: AllData, val etag: String = allData.hashCode().toString())