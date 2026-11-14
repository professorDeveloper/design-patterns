package structural.facade.travel_example

class TravelFacade(private val recipient: Recipient) {
    private val hotelBooking = HotelBooking(recipient)
    private val flightBooking = FlightBooking(recipient)
    private val payment = Payment(recipient)

    fun bookTravel() {
        hotelBooking.bookHotel()
        flightBooking.bookFlight()
        payment.makePayment()
    }


    fun cancelTravel() {
        hotelBooking.cancelHotel()
        flightBooking.cancelFlight()
        payment.refundPayment()
    }
}