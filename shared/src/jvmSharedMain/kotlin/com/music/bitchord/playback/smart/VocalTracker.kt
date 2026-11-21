package com.music.bitchord.playback.smart

/** The linear-frequency STFT front end open-unmix was trained on (stubbed). */
object VocalSpectrogram {
    val available: Boolean = false
    val bins: Int = 2049
    val sampleRate: Double = 44_100.0
    val hop: Int = 1024
    val fftSize: Int = 4096
    val frameRate: Double get() = sampleRate / hop

    fun compute(left: FloatArray, right: FloatArray, rate: Double = sampleRate): Spectrogram? = null

    data class Spectrogram(val values: FloatArray, val frames: Int, val bins: Int) {
        override fun equals(other: Any?): Boolean =
            this === other || (other is Spectrogram && frames == other.frames &&
                bins == other.bins && values.contentEquals(other.values))

        override fun hashCode(): Int = 31 * (31 * values.contentHashCode() + frames) + bins
    }

    const val CHANNELS = 2
}

/**
 * Stubbed VocalTracker (ONNX Runtime and open-unmix model removed to reduce APK size).
 */
class VocalTracker(
    private val modelPath: () -> String,
    private val inferenceThreads: () -> Int,
) {
    fun track(left: FloatArray, right: FloatArray, rate: Double): FloatArray? = null

    fun release() {}

    companion object {
        const val MODEL_ASSET = "vocals_umxhq_int8.onnx"
        const val FIXED_FRAMES = 960
    }
}
