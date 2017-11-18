package io.github.golok56.androidarchitecturetest

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import java.util.*

/**
 * @author Satria Adi Putra
 */
class LiveDataTimerViewModel() : ViewModel() {
    companion object {
        private val ONE_SECOND = 1000L
    }

    val elapsedTime = MutableLiveData<Long>()

    private var initialTime = SystemClock.elapsedRealtime()

    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object: TimerTask(){
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000
                Handler(Looper.getMainLooper()).post({ elapsedTime.value = newValue })
            }
        }, ONE_SECOND, ONE_SECOND)
    }

}