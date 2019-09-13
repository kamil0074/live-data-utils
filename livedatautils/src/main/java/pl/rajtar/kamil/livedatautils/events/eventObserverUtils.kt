package pl.rajtar.kamil.livedatautils.events

import androidx.lifecycle.Observer

fun <T : Any> Observer<T>.toEventObserver() =
    EventObserverWrapper(this)