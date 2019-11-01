package pl.rajtar.kamil.livedatautils.events

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any> Observer<T>.toEventObserver() =
    EventObserverWrapper(this)

fun <T : Any> LiveData<Event<T>>.observeEvents(lifecycleOwner:LifecycleOwner,observer: Observer<T>) =
    observe(lifecycleOwner,observer.toEventObserver())