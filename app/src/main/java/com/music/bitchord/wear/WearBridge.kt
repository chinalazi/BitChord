package com.music.bitchord.wear

import android.content.Context
import androidx.media3.common.Player
import androidx.media3.datasource.DataSource
import com.music.bitchord.playback.cast.NoSpeaker
import com.music.bitchord.playback.cast.RemoteSpeaker
import com.music.bitchord.widget.MediaWidgetSnapshot
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Stubbed WearBridge (Wear OS Wearable Data Layer removed to reduce APK size).
 */
object WearBridge {
    private val _watchSession = MutableStateFlow(false)
    val watchSession: StateFlow<Boolean> = _watchSession.asStateFlow()

    private val _watchOutput = MutableStateFlow(WatchOutputState())
    val watchOutput: StateFlow<WatchOutputState> = _watchOutput.asStateFlow()

    fun attachStreams(factory: DataSource.Factory?) {}

    fun refreshWatchOutput(context: Context) {}

    fun selectWatchOutput() {}

    fun leaveWatchOutput() {}

    fun setWatchVolume(fraction: Float) {}

    fun createSpeaker(
        context: Context,
        scope: CoroutineScope,
        localPlayer: () -> Player?,
        onChanged: () -> Unit,
    ): RemoteSpeaker = NoSpeaker

    fun releaseSpeaker() {}

    internal fun publish(
        context: Context,
        snapshot: MediaWidgetSnapshot,
        player: Player?,
        playing: Boolean?,
    ) {}

    fun republish(context: Context, player: Player) {}
}
