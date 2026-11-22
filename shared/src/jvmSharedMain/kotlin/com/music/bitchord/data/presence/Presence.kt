package com.music.bitchord.data.presence

enum class PresencePlatform(val wire: String) { Android("android"), Pc("pc") }

/**
 * Stubbed Presence (telemetry / open-app ping disabled).
 */
class Presence(
    private val platform: PresencePlatform,
    private val installId: String,
    private val endpoint: String = "",
) {
    fun setOpen(isOpen: Boolean) {}

    fun closeBlocking() {}

    companion object {
        const val ENDPOINT = ""
    }
}
