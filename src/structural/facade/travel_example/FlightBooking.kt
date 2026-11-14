package structural.facade.travel_example

class FlightBooking (private val recipient: Recipient)  {
    fun bookFlight() {
        println("Flight booked for ${recipient.name}")
    }

    fun cancelFlight() {
        println("Flight booking canceled for ${recipient.name}")
    }
}