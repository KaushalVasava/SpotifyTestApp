package com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Image
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Owner
import kotlinx.parcelize.Parcelize

@Entity("playlist_table")
@Parcelize
data class Playlist(
    val collaborative: Boolean,
    val description: String,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val owner: Owner,
    @SerializedName("primary_color")
    val primaryColor: String?,
    val `public`: String?,
    @SerializedName("snapshot_id")
    val snapshotId: String,
    val tracks: PlaylistTracks,
    val type: String,
    val uri: String
) : Parcelable