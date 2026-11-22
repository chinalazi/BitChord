package com.music.bitchord.playback.audio.bluetooth

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class BluetoothTelemetry(
    val isConnected: Boolean = false,
    val deviceName: String? = null,
    val codecName: String = "Unknown",
    val sampleRateHz: Int? = null,
    val bitDepth: Int? = null,
    val bitrateLabel: String = "Not exposed by Android",
    val mode: String? = null,
    val isAuthoritative: Boolean = false,
    val lastUpdatedMs: Long = 0L,
) {
    val isHighRes: Boolean = false
    val hasNamedCodec: Boolean = false
    fun formattedSummary(): String = ""
}

/**
 * Stubbed BluetoothAudioTracker (Bluetooth audio tracking/UI removed; audio uses system routing).
 */
class BluetoothAudioTracker(private val context: Context) {
    private val _telemetry = MutableStateFlow(BluetoothTelemetry())
    val telemetry: StateFlow<BluetoothTelemetry> = _telemetry.asStateFlow()

    fun start() {}

    fun stop() {}

    fun refreshCurrentDevice() {}
}
