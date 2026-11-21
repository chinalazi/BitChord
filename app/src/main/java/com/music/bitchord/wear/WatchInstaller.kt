package com.music.bitchord.wear

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Stubbed WatchInstaller (Wear OS / libadb / BouncyCastle removed to reduce APK size).
 */
object WatchInstaller {
    private val _watches = MutableStateFlow<List<WatchEntry>?>(null)
    val watches: StateFlow<List<WatchEntry>?> = _watches.asStateFlow()

    private val _update = MutableStateFlow<WatchUpdateState>(WatchUpdateState.Idle)
    val update: StateFlow<WatchUpdateState> = _update.asStateFlow()

    private val _pairing = MutableStateFlow<WatchPairingState>(WatchPairingState.Idle)
    val pairing: StateFlow<WatchPairingState> = _pairing.asStateFlow()

    fun available(context: Context): Boolean = false

    fun refresh(context: Context) {}

    fun sendUpdate(context: Context, nodeId: String) {}

    fun startPairing(context: Context) {}

    fun stopPairing() {}

    fun pairAndInstall(context: Context, nodeId: String, code: String) {}
}
