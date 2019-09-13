package pl.rajtar.kamil.livedatautils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import pl.rajtar.kamil.livedatautils.events.Event

fun <T:Any> LiveData<Event<T>>.setUpChangeLocationLiveData(
		lifecycleOwner:LifecycleOwner,
		navController:NavController,
		locationProvider:(T)->NavDirections) {
	val renameGroupObserver = ChangeLocationObserver(
			navController,
			locationProvider)
	observe(lifecycleOwner,renameGroupObserver)
}
