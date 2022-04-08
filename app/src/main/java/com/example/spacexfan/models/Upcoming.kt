package com.example.spacexfan.models


import com.google.gson.annotations.SerializedName

class Upcoming : ArrayList<Upcoming.UpcomingItem>(){
    data class UpcomingItem(
        @SerializedName("auto_update")
        val autoUpdate: Boolean?,
        @SerializedName("capsules")
        val capsules: List<Any?>?,
        @SerializedName("cores")
        val cores: List<Core?>?,
        @SerializedName("crew")
        val crew: List<Any?>?,
        @SerializedName("date_local")
        val dateLocal: String?,
        @SerializedName("date_precision")
        val datePrecision: String?,
        @SerializedName("date_unix")
        val dateUnix: Int?,
        @SerializedName("date_utc")
        val dateUtc: String?,
        @SerializedName("details")
        val details: String?,
        @SerializedName("failures")
        val failures: List<Any?>?,
        @SerializedName("fairings")
        val fairings: Fairings?,
        @SerializedName("flight_number")
        val flightNumber: Int?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("launch_library_id")
        val launchLibraryİd: String?,
        @SerializedName("launchpad")
        val launchpad: String?,
        @SerializedName("links")
        val links: Links?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("net")
        val net: Boolean?,
        @SerializedName("payloads")
        val payloads: List<String?>?,
        @SerializedName("rocket")
        val rocket: String?,
        @SerializedName("ships")
        val ships: List<Any?>?,
        @SerializedName("static_fire_date_unix")
        val staticFireDateUnix: Any?,
        @SerializedName("static_fire_date_utc")
        val staticFireDateUtc: Any?,
        @SerializedName("success")
        val success: Any?,
        @SerializedName("tbd")
        val tbd: Boolean?,
        @SerializedName("upcoming")
        val upcoming: Boolean?,
        @SerializedName("window")
        val window: Any?
    ) {
        data class Core(
            @SerializedName("core")
            val core: String?,
            @SerializedName("flight")
            val flight: Any?,
            @SerializedName("gridfins")
            val gridfins: Any?,
            @SerializedName("landing_attempt")
            val landingAttempt: Any?,
            @SerializedName("landing_success")
            val landingSuccess: Any?,
            @SerializedName("landing_type")
            val landingType: Any?,
            @SerializedName("landpad")
            val landpad: Any?,
            @SerializedName("legs")
            val legs: Any?,
            @SerializedName("reused")
            val reused: Boolean?
        )
    
        data class Fairings(
            @SerializedName("recovered")
            val recovered: Any?,
            @SerializedName("recovery_attempt")
            val recoveryAttempt: Any?,
            @SerializedName("reused")
            val reused: Any?,
            @SerializedName("ships")
            val ships: List<Any?>?
        )
    
        data class Links(
            @SerializedName("article")
            val article: Any?,
            @SerializedName("flickr")
            val flickr: Flickr?,
            @SerializedName("patch")
            val patch: Patch?,
            @SerializedName("presskit")
            val presskit: Any?,
            @SerializedName("reddit")
            val reddit: Reddit?,
            @SerializedName("webcast")
            val webcast: Any?,
            @SerializedName("wikipedia")
            val wikipedia: Any?,
            @SerializedName("youtube_id")
            val youtubeİd: Any?
        ) {
            data class Flickr(
                @SerializedName("original")
                val original: List<Any?>?,
                @SerializedName("small")
                val small: List<Any?>?
            )
    
            data class Patch(
                @SerializedName("large")
                val large: Any?,
                @SerializedName("small")
                val small: Any?
            )
    
            data class Reddit(
                @SerializedName("campaign")
                val campaign: Any?,
                @SerializedName("launch")
                val launch: Any?,
                @SerializedName("media")
                val media: Any?,
                @SerializedName("recovery")
                val recovery: Any?
            )
        }
    }
}