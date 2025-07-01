package org.examples.bookMyShow.seat;

public class SeatFactory {
    public static Seat createSeat(String id, int row, int col) {
        SeatType type = (row <= 2) ? SeatType.PREMIUM : SeatType.NORMAL;
        double price = (type == SeatType.PREMIUM) ? 150.0 : 100.0;

        return new Seat(id, type, row, col, price);
    }
}
