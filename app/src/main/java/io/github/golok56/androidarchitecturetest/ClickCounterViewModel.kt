package io.github.golok56.androidarchitecturetest

import android.arch.lifecycle.ViewModel

/**
 * @author Satria Adi Putra
 */
open class ClickCounterViewModel : ViewModel() {
    open var currentCount = 0
}