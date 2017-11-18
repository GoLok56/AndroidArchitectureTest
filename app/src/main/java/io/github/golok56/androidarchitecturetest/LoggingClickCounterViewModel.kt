package io.github.golok56.androidarchitecturetest

/**
 * @author Satria Adi Putra
 */
class LoggingClickCounterViewModel(private var loggingInterceptor: LoggingInterceptor) : ClickCounterViewModel() {
    override var currentCount = 0
        set(value) {
            field = value
            loggingInterceptor.intercept(value)
        }
}