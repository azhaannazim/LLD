package org.examples.bookMyShow;

import org.examples.bookMyShow.booking.Booking;
import org.examples.bookMyShow.payment.CreditCard;
import org.examples.bookMyShow.payment.Payment;
import org.examples.bookMyShow.payment.UPI;
import org.examples.bookMyShow.seat.Seat;
import org.examples.bookMyShow.seat.SeatFactory;
import org.examples.bookMyShow.seat.SeatType;

import java.time.LocalDateTime;
import java.util.*;

public class App {
    public static void main(String[] args) {
        BookingSystem bookingSystem = BookingSystem.getInstance();

        // Add movies
        Movie movie1 = new Movie("M1", "Movie 1", 120,"Description 1");
        Movie movie2 = new Movie("M2", "Movie 2", 135,"Description 2");
        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);

        // Add theaters
        Theater theater1 = new Theater("T1", "Theater 1", "Location 1", new ArrayList<>());
        Theater theater2 = new Theater("T2", "Theater 2", "Location 2", new ArrayList<>());
        bookingSystem.addTheater(theater1);
        bookingSystem.addTheater(theater2);

        // Add shows
        Show show1 = new Show("S1", movie1, theater1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie1.getDurationInMinutes()), createSeats(10, 10));
        Show show2 = new Show("S2", movie2, theater2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie2.getDurationInMinutes()), createSeats(8, 8));
        bookingSystem.addShow(show1);
        bookingSystem.addShow(show2);

        //Payment
        Payment CC = new CreditCard();
        Payment UPI = new UPI();

        // Book tickets
        User user = new User("U1", "John Doe", "john@example.com");
        List<Seat> selectedSeats = new ArrayList<>();
        for (Seat seat : show1.getSeats().values()) {
            if (seat.getRow() == 1 && (seat.getCol() == 5 || seat.getCol() == 6)) {
                selectedSeats.add(seat);
            }
        }
        Booking booking = bookingSystem.bookTickets(user, show1, selectedSeats);
        if (booking != null) {
            System.out.println("Booking successful. Booking ID: " + booking.getId());
            bookingSystem.confirmBooking(booking.getId() , CC);
        } else {
            System.out.println("Booking failed. Seats not available.");
        }

        // Cancel booking
        bookingSystem.cancelBooking(booking.getId());
        System.out.println("Booking canceled. Booking ID: " + booking.getId());
    }

    private static Map<String, Seat> createSeats(int rows, int columns) {
        Map<String, Seat> seats = new HashMap<>();
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= columns; col++) {
                String seatId = row + "-" + col + UUID.randomUUID().toString().replace("-","").substring(0,8);
//               factory method
                Seat seat = SeatFactory.createSeat(seatId, row, col);
                seats.put(seatId, seat);
            }
        }
        return seats;
    }
}
