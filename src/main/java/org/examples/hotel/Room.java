package org.examples.hotel;

public class Room {
    private final String id;
    private final RoomType type;
    private RoomStatus status;
    private final double price;

    public Room(String id, RoomType type, double price) {
        this.id = id;
        this.type = type;
        this.status = RoomStatus.AVAILABLE;
        this.price = price;
    }

    public synchronized void book() {
        if (status == RoomStatus.AVAILABLE) {
            status = RoomStatus.BOOKED;
        } else {
            throw new IllegalStateException("Room is not available for booking.");
        }
    }
    public synchronized void checkin(){
        if (status == RoomStatus.BOOKED) {
            status = RoomStatus.OCCUPIED;
        } else {
            throw new IllegalStateException("Room is not booked.");
        }
    }
    public synchronized void checkout(){
        if (status == RoomStatus.OCCUPIED) {
            status = RoomStatus.AVAILABLE;
        } else {
            throw new IllegalStateException("Room is not occupied");
        }
    }

    public String getId() {
        return id;
    }

    public RoomType getType() {
        return type;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }
}
