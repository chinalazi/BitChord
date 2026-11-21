package com.music.bitchord.playback.cast

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Stubbed CastController (Google Cast framework removed to reduce APK size).
 */
object CastController {
    data class Device(
        val id: String,
        val name: String,
        val connecting: Boolean,
        val connected: Boolean,
    )

    data class State(
        val supported: Boolean = false,
        val devices: List<Device> = emptyList(),
        val connectedName: String? = null,
        val connecting: Boolean = false,
    ) {
        val casting: Boolean get() = connectedName != null
    }

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    private val _volume = MutableStateFlow(1f)
    val volume: StateFlow<Float> = _volume.asStateFlow()

    fun ensureStarted(context: Context) {}

    fun attach(target: CastPlayback) {}

    fun detach(target: CastPlayback) {}

    fun discover(active: Boolean): () -> Unit = {}

    fun connect(deviceId: String) {}

    fun disconnect(resumeHere: Boolean) {}

    fun setVolume(level: Float) {}
}
