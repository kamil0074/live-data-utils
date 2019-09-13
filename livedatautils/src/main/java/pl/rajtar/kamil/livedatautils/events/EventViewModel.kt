package pl.rajtar.kamil.livedatautils.events

import androidx.lifecycle.MutableLiveData

class EventViewModel<T:Any>(override val events:MutableLiveData<Event<T>>):
	IEventViewModel<T> {
	override fun post(data:T) {
		events.postValue(Event(data))
	}
}