package pl.rajtar.kamil.livedatautils.events

import androidx.lifecycle.Observer

class EventObserverWrapper<T : Any>(private val baseObserver: Observer<T>) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>) {
        event.getIfNotHandled().let(baseObserver::onChanged)
    }
}
