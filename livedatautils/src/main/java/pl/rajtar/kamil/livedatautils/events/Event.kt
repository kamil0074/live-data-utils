package pl.rajtar.kamil.livedatautils.events

import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by Kamil Rajtar on 10.10.18.  */
class Event<T:Any>(private val value:T) {
	private val handled = AtomicBoolean(false)
	fun getIfNotHandled():T? {
		return if(!handled.getAndSet(true)) {
			value
		} else {
			null
		}
	}

	fun peek():T {
		return value
	}
}
