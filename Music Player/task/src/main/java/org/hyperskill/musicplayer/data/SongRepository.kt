package org.hyperskill.musicplayer.data

import org.hyperskill.musicplayer.domain.Song

interface SongRepository  {
    fun getSongList(): List<Song>
}