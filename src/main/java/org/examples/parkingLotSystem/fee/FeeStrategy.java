package org.examples.parkingLotSystem.fee;

import org.examples.parkingLotSystem.Ticket;

//5
public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
