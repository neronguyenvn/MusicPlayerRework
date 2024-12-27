package org.hyperskill.musicplayer.domain

data class Track(
    val song: Song,
    val state: State = State.Stopped,
) {
    enum class State {
        Playing, Paused, Stopped
    }
}
