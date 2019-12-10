package com.example.mvvmbasicproject.model

import com.google.gson.annotations.SerializedName

class Owner {

    @SerializedName("received_events_url")
    var receivedEventsUrl: String = ""
    @SerializedName("organizations_url")
    var organizationsUrl: String = ""
    @SerializedName("avatar_url")
    var avatarUrl: String = ""
    @SerializedName("gravatar_id")
    var gravatarId: String = ""
    @SerializedName("gists_url")
    var gistsUrl: String = ""
    @SerializedName("starred_url")
    var starredUrl: String = ""
    @SerializedName("site_admin")
    var siteAdmin: String = ""
    @SerializedName("type")
    var type: String = ""
    @SerializedName("url")
    var url: String = ""
    @SerializedName("id")
    var id: String = ""
    @SerializedName("html_url")
    var htmlUrl: String = ""
    @SerializedName("following_url")
    var followingUrl: String = ""
    @SerializedName("events_url")
    var eventsUrl: String = ""
    @SerializedName("login")
    var login: String = ""
    @SerializedName("subscriptions_url")
    var subscriptionsUrl: String = ""
    @SerializedName("repos_url")
    var reposUrl: String = ""
    @SerializedName("followers_url")
    var followersUrl: String = ""
}