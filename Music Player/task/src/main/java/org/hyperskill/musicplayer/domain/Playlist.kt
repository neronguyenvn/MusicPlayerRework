package org.hyperskill.musicplayer.domain

data class Playlist(
    val name: String,
    val tracks: List<Track>,
    val currentTrackIndex: Int = -1
)
