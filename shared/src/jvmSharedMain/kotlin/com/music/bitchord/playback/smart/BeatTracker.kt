package com.music.bitchord.playback.smart

/**
 * Stubbed BeatTracker (ONNX Runtime and Beat This! model removed to reduce APK size).
 */
class BeatTracker(
    private val modelPath: () -> String,
    private val inferenceThreads: () -> Int,
) {
    data class Grid(
        val beats: List<Double>,
        val downbeats: List<Double>,
        val bpm: Double,
        val beatInterval: Double,
        val firstBeat: Double,
        val beatConfidence: Double,
    )

    fun track(pcm: FloatArray, offsetSeconds: Double = 0.0): Grid? = null

    fun release() {}

    companion object {
        const val MODEL_ASSET = "beat_this_final0_q8.onnx"
        const val RETIRED_MODEL_ASSET = "beat_this_int8.onnx"
        const val CHUNK_FRAMES = 1500
        const val BORDER_FRAMES = 6
        const val WINDOW_SECONDS = (CHUNK_FRAMES - 2 * BORDER_FRAMES) / 50.0
        fun tempoFromBeats(beats: List<Double>): Double = 0.0
    }
}
