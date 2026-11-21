package com.music.bitchord.playback.cast

import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.CoroutineScope

class CastStream(val url: String, val mimeType: String)

interface CastSink {
    fun onRemotePlaybackChanged()
    fun onRemoteRouteChanged()
    fun onRemoteVolumeChanged()
}

/**
 * Stubbed CastPlayback (Google Cast framework removed to reduce APK size).
 */
class CastPlayback(
    private val scope: CoroutineScope,
    private val localPlayer: () -> ExoPlayer?,
    private val resolve: suspend (MediaItem) -> CastStream?,
    private val say: (Int) -> Unit,
) : RemoteSpeaker by NoSpeaker {
    var resumeHereOnEnd = false
    fun release() {}

    companion object {
        fun mimeTypeOf(uri: Uri): String = "audio/mp4"
    }
}
