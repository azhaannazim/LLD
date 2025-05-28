package org.examples.parkingLotSystem;

import org.examples.parkingLotSystem.vehicleType.Vehicle;
import org.examples.parkingLotSystem.vehicleType.VehicleType;

//2
public class ParkingSpot {
    private final int spotNo;
    private final VehicleType type;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int spotNo ,VehicleType type){
        this.spotNo = spotNo;
        this.type = type;

        this.isOccupied = false;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }
    public synchronized boolean park(Vehicle vehicle){
        if(isOccupied || vehicle.getType() != type){
            return false;
        }
        this.vehicle = vehicle;
        isOccupied = true;

        return true;
    }
    public synchronized void unpark(){
        this.vehicle = null;
        this.isOccupied = false;
    }
    public int getSpotNo() {
        return spotNo;
    }

    public VehicleType getType() {
        return type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
