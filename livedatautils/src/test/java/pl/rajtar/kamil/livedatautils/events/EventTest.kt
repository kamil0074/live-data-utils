package pl.rajtar.kamil.livedatautils.events

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Created by Kamil Rajtar on 11.06.19.
 */
internal class EventTest {

    @Test
    internal fun onceReturnValue() {
        val event = Event(Unit)
        val actual = event.getIfNotHandled()
        Assertions.assertEquals(Unit, actual)
    }

    @Test
    internal fun twiceReturnValue() {
        val event = Event(Unit)
        event.getIfNotHandled()
        val actual = event.getIfNotHandled()
        Assertions.assertEquals(null, actual)
    }

    @Test
    internal fun peekAlreadyUsedValue() {
        val event = Event(Unit)
        event.getIfNotHandled()
        val actual = event.peek()
        Assertions.assertEquals(Unit, actual)
    }

    @Test
    internal fun peekThenUse() {
        val event = Event(Unit)
        event.peek()
        val actual = event.getIfNotHandled()
        Assertions.assertEquals(Unit, actual)
    }

}
