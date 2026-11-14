package structural.facade.travel_example

fun main() {
    val recipient = Recipient(1, "John Doe", 30)
    val travelFacade = TravelFacade(recipient)

    println("Booking travel...")
    travelFacade.bookTravel()

    println("\nCanceling travel...")
    travelFacade.cancelTravel()
}