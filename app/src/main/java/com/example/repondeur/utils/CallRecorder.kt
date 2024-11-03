package utils

import android.media.MediaRecorder
import java.io.IOException

class CallRecorder {

    private var recorder: MediaRecorder? = null

    fun startRecording(filePath: String) {
        // Initialize the MediaRecorder instance if it's not already created
        recorder = MediaRecorder().apply {
            try {
                // Configure the recorder settings
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                setOutputFile(filePath)

                // Prepare and start recording
                prepare()
                start()
            } catch (e: IOException) {
                e.printStackTrace()
                // Handle exception and reset the recorder
                resetRecorder()
            } catch (e: IllegalStateException) {
                e.printStackTrace()
                resetRecorder()
            }
        }
    }

    fun stopRecording() {
        recorder?.let {
            try {
                // Stop and release the recorder safely
                it.stop()
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            } catch (e: RuntimeException) {
                e.printStackTrace()
            } finally {
                it.release()
                recorder = null
            }
        }
    }

    private fun resetRecorder() {
        recorder?.release()
        recorder = null
    }
}
