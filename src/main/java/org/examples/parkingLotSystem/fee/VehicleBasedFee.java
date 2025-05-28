package org.examples.parkingLotSystem.fee;

import org.examples.parkingLotSystem.Ticket;
import org.examples.parkingLotSystem.vehicleType.VehicleType;

import java.util.Map;

public class VehicleBasedFee implements FeeStrategy {
    private final Map<VehicleType, Double> hourlyRates = Map.of(
            VehicleType.CAR, 20.0,
            VehicleType.BIKE, 10.0,
            VehicleType.TRUCK, 30.0
    );
    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * hourlyRates.get(ticket.getVehicle().getType());
    }
}
