package structural.facade.travel_example

class HotelBooking (private val recipient: Recipient) {
    fun bookHotel() {
        println("Hotel booked for ${recipient.name}")
    }

    fun cancelHotel() {
        println("Hotel booking canceled for ${recipient.name}")
    }
}