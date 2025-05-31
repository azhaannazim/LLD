package org.examples.hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    private String id;
    private Guest guest;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private ReservationStatus status;

    public Reservation(String id, Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = ReservationStatus.CONFIRMED;
    }
    public synchronized void cancel() {
        if (status == ReservationStatus.CONFIRMED) {
            status = ReservationStatus.CANCELLED;
            room.checkout();
        } else {
            throw new IllegalStateException("Reservation is not confirmed.");
        }
    }

    public String getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkIn;
    }

    public LocalDate getCheckOutDate() {
        return checkOut;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}
