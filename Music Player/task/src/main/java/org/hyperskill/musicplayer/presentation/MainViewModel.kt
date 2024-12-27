package org.hyperskill.musicplayer.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.hyperskill.musicplayer.domain.Playlist
import org.hyperskill.musicplayer.domain.Track

class MainViewModel : ViewModel() {

    private val _playlist = MutableStateFlow<Playlist?>(null)
    private val _uiState = MutableStateFlow(UiState.PlayMusic(emptyList()))
    val uiState = _uiState.asStateFlow()

    fun updateCurrentTrack(value: Track) {
        _playlist.update { playlist ->
            playlist.map { track ->
                if (track.song.id == value.song.id) value else track
            }
        }
    }

    fun loadPlaylist(playlist: Playlist) {
        _playlist.update { playlist }
    }

    sealed interface UiState {

        data class PlayMusic(val currentPlaylist: Playlist) : UiState

        data object AddPlaylist : UiState
    }
}
