package io.github.golok56.androidarchitecturetest

import android.util.Log

/**
 * @author Satria Adi Putra
 */
class LoggingInterceptor() {
    private val LOG_TAG = LoggingInterceptor::class.java.getSimpleName()

    fun intercept(count: Int){
        Log.d(LOG_TAG, "Clicked ${count} times!")
    }
}