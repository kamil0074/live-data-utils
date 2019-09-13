package pl.rajtar.kamil.livedatautils

import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import pl.rajtar.kamil.livedatautils.events.Event

internal class ChangeLocationObserver<T:Any>(
		private val navController:NavController,
		private val directionsProvider:(T)->NavDirections):Observer<Event<T>> {
	override fun onChanged(event: Event<T>) {
		event.getIfNotHandled()?.let {
			val directions = directionsProvider(it)
			navController.navigate(directions)
		}
	}
}
