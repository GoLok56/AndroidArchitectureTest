package io.github.golok56.androidarchitecturetest

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * @author Satria Adi Putra
 */
class LoggingClickCounterViewModelFactory(val loggingInterceptor: LoggingInterceptor) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoggingClickCounterViewModel::class.java)){
            return LoggingClickCounterViewModel(loggingInterceptor) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class!")
    }
}