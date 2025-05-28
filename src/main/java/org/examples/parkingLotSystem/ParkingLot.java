package org.examples.parkingLotSystem;

import org.examples.parkingLotSystem.fee.FeeStrategy;
import org.examples.parkingLotSystem.fee.FlatRateFee;
import org.examples.parkingLotSystem.vehicleType.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
//6
public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors;
    private Map<String , Ticket> availableTickets = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot() {
        floors = new ArrayList<>();
        feeStrategy = new FlatRateFee(); //factory method
    }
    public synchronized static ParkingLot getInstance(){ //singleton
        if(instance == null){
            return new ParkingLot();
        }
        return instance;
    }
    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy (FeeStrategy feeStrategy) { //strategy method
        this.feeStrategy = feeStrategy;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spotOptional = floor.getParkingSpot(vehicle.getType());

            if (!spotOptional.isPresent()) continue;

            ParkingSpot spot = spotOptional.get();

            if (spot.park(vehicle)) {
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket(ticketId, vehicle, spot);
                availableTickets.put(ticketId, ticket);
                return ticket;
            }
        }
        throw new Exception("No available parking spot for vehicle type: " + vehicle.getType());
    }
    public synchronized double unpark(String ticketId) throws Exception{
        Ticket ticket = availableTickets.remove(ticketId);
        if (ticket == null) {
            throw new Exception("Invalid ticket");
        }
        ParkingSpot spot = ticket.getParkingSpot();
        spot.unpark();
        ticket.setExitTime();

        return feeStrategy.calculateFee(ticket);
    }

    public List<ParkingFloor> getParkingFloors() {
        return floors;
    }
}
