package com.music.bitchord.playback

import android.net.Uri
import androidx.media3.datasource.BaseDataSource
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DataSpec
import java.io.IOException

/**
 * Stubbed SmbDataSource (smbj removed to reduce APK size).
 */
class SmbDataSource : BaseDataSource(/* isNetwork = */ true) {
    override fun open(dataSpec: DataSpec): Long {
        throw IOException("SMB support removed")
    }

    override fun read(buffer: ByteArray, offset: Int, readLength: Int): Int = -1

    override fun getUri(): Uri? = null

    override fun close() {}

    class Factory : DataSource.Factory {
        override fun createDataSource(): DataSource = SmbDataSource()
    }

    class RoutingFactory(private val downstream: DataSource.Factory) : DataSource.Factory {
        override fun createDataSource(): DataSource = downstream.createDataSource()
    }
}
