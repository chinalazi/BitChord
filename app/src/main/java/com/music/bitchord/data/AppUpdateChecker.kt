package com.music.bitchord.data

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.File

/**
 * Stubbed AppUpdateChecker (in-app update checks disabled).
 */
object AppUpdateChecker {

    data class UpdateInfo(
        val version: String,
        val releaseUrl: String,
        val apkUrl: String?,
        val notes: String?,
    )

    sealed interface DownloadState {
        data object Idle : DownloadState
        data class Downloading(val fraction: Float) : DownloadState
        data class Ready(val file: File) : DownloadState
        data class Failed(val message: String) : DownloadState
    }

    private val _available = MutableStateFlow<UpdateInfo?>(null)
    val available = _available

    private val _download = MutableStateFlow<DownloadState>(DownloadState.Idle)
    val download = _download

    fun clearCache(context: Context) {}

    suspend fun check() {}

    suspend fun downloadApk(context: Context) {}

    fun cancelDownload() {}

    fun resetDownload() {}

    fun installApk(context: Context, file: File) {}
}
