package io.github.golok56.androidarchitecturetest

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName
    private lateinit var mLiveDataModel : LiveDataTimerViewModel

    private val elapsedTimeObserver = Observer<Long> { newValue ->
        val newText = MainActivity::this.resources.getString(R.string.seconds, newValue)
        displayTimerText(newText)
        Log.d(LOG_TAG, "Updating timer")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewModelProviders.of(this).get(LiveDataTimerViewModel::class.java)
        subscribeElapsedTimeObserver()
    }

    fun subscribeElapsedTimeObserver(){
        mLiveDataModel.elapsedTime.observe(this, elapsedTimeObserver)
    }

    fun displayTimerText(newText: String){
        timerValueText.text = newText
    }
}
