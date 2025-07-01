package org.examples.bookMyShow.seat;

public class Seat {
    private String id;
    private SeatType type;
    private int row;
    private int col;
    private double price;
    private SeatStatus status;

    public Seat(String id, SeatType type, int row, int col, double price) {
        this.id = id;
        this.type = type;
        this.row = row;
        this.col = col;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public SeatType getType() {
        return type;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getPrice() {
        return price;
    }

    public SeatStatus getStatus() {
        return status;
    }
}
