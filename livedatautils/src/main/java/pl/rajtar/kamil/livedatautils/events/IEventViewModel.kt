package pl.rajtar.kamil.livedatautils.events

import androidx.lifecycle.LiveData

interface IEventViewModel<T:Any> {
	val events:LiveData<Event<T>>
	fun post(data:T)
}
