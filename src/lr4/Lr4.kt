package lr4


fun main() {
    val cinema = Cinema()
    cinema.createCinema()
    cinema.showMenu()
}

class Cinema {
    private lateinit var seats: Array<Array<String>>
    private var totalIncome = 0
    private var currentIncome = 0
    private var purchasedTickets = 0
    private var rows = 0
    private var seatsPerRow = 0

    fun createCinema() {
        println("Enter the number of rows:")
        rows = readLine()!!.toInt()
        println("Enter the number of seats in each row:")
        seatsPerRow = readLine()!!.toInt()
        seats = Array(rows) { Array(seatsPerRow) { "S" } }
        totalIncome = calculateTotalIncome()
    }

    fun showMenu() {
        while (true) {
            println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
            when (readLine()!!.toInt()) {
                1 -> showSeats()
                2 -> buyTicket()
                3 -> showStatistics()
                0 -> return
                else -> println("Wrong input!")
            }
        }
    }

    private fun showSeats() {
        println("\nCinema:")
        print(" ")
        repeat(seatsPerRow) { print(" ${it + 1}") }
        println()
        seats.forEachIndexed { index, row ->
            print("${index + 1}")
            row.forEach { print(" $it") }
            println()
        }
    }

    private fun buyTicket() {
        while (true) {
            println("\nEnter a row number:")
            val selectedRow = readLine()!!.toInt()
            println("Enter a seat number in that row:")
            val selectedSeat = readLine()!!.toInt()

            if (selectedRow !in 1..rows || selectedSeat !in 1..seatsPerRow) {
                println("Wrong input!")
                continue
            }

            if (seats[selectedRow - 1][selectedSeat - 1] == "B") {
                println("That ticket has already been purchased!")
                continue
            }

            val price = calculateTicketPrice(selectedRow)
            println("Ticket price: $$price")
            seats[selectedRow - 1][selectedSeat - 1] = "B"
            currentIncome += price
            purchasedTickets++
            break
        }
    }

    private fun calculateTicketPrice(selectedRow: Int): Int {
        val totalSeats = rows * seatsPerRow
        return if (totalSeats <= 60 || selectedRow <= rows / 2) {
            10
        } else {
            val frontHalfPrice = 10 * (rows / 2 * seatsPerRow)
            val backHalfPrice = 8 * ((rows + 1) / 2 * seatsPerRow)
            if (selectedRow <= rows / 2) frontHalfPrice else backHalfPrice
        }
    }

    private fun showStatistics() {
        val percentage = purchasedTickets.toDouble() / (rows * seatsPerRow) * 100
        val formattedPercentage = "%.2f".format(percentage)
        println("\nNumber of purchased tickets: $purchasedTickets")
        println("Percentage: $formattedPercentage%")
        println("Current income: $$currentIncome")
        println("Total income: $$totalIncome")
    }

    private fun calculateTotalIncome(): Int {
        return if (rows * seatsPerRow <= 60) {
            rows * seatsPerRow * 10
        } else {
            val frontHalfPrice = 10 * (rows / 2 * seatsPerRow)
            val backHalfPrice = 8 * ((rows + 1) / 2 * seatsPerRow)
            frontHalfPrice + backHalfPrice
        }
    }
}