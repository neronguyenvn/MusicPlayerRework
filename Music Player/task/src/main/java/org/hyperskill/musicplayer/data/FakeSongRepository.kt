package org.hyperskill.musicplayer.data

import org.hyperskill.musicplayer.domain.Song
import org.hyperskill.musicplayer.domain.Track

class FakeSongRepository : SongRepository {
    override fun getSongList(): List<Song> {
        return (1..10).map {
            Song(
                id = it,
                artist = "artist$it",
                title = "title$it",
                duration = 215_000
            )
        }
    }
}
