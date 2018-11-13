package sample

/**
 * Created by @iamBedant on 13/11/18.
 */
data class AllData(
    val name: String
)

class SessionizeData(val allData: AllData, val etag: String = allData.hashCode().toString())