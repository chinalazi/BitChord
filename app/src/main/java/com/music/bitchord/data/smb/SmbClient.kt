package com.music.bitchord.data.smb

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Stubbed SmbClient (smbj removed to reduce APK size).
 */
object SmbClient {
    data class Entry(
        val path: String,
        val isDirectory: Boolean,
        val size: Long,
    )

    data class Listing(val audio: List<Entry>, val images: List<Entry>)

    suspend fun testConnection(
        host: String,
        share: String,
        basePath: String,
        username: String,
        password: String,
    ): Result<Unit> = withContext(Dispatchers.IO) {
        Result.failure(UnsupportedOperationException("SMB support removed"))
    }

    suspend fun listLibrary(maxFiles: Int = 10_000): Result<Listing> = withContext(Dispatchers.IO) {
        Result.failure(UnsupportedOperationException("SMB support removed"))
    }

    fun readFully(streamUrl: String, maxBytes: Long = 16 * 1024 * 1024): ByteArray =
        throw SmbConnection.SmbException("SMB support removed")

    fun smbPath(displayPath: String): String =
        displayPath.replace('/', '\\').trim('\\').ifBlank { "" }
}
