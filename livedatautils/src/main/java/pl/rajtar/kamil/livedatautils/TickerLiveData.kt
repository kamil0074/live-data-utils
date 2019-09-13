package pl.rajtar.kamil.livedatautils

import androidx.lifecycle.LiveData
import pl.rajtar.kamil.livedatautils.events.Event
import java.util.*

/**
 * Created by Kamil Rajtar on 11.10.18.  */
class TickerLiveData(private val timer:Timer,
					 private val periodInMillis:Long):LiveData<Event<Unit>>() {

	private var task:TimerTask? = null

	override fun onActive() {
		task = TickTask().also {timer.scheduleAtFixedRate(it,0,periodInMillis)}
	}

	override fun onInactive() {
		task?.cancel()
		task = null
	}

	private inner class TickTask:TimerTask() {
		override fun run() {
			postValue(Event(Unit))
		}
	}
}
