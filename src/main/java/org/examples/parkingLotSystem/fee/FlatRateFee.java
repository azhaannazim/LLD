package org.examples.parkingLotSystem.fee;

import org.examples.parkingLotSystem.Ticket;

public class FlatRateFee implements FeeStrategy {

    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * RATE_PER_HOUR;
    }
}
