package org.examples.parkingLotSystem;

import org.examples.parkingLotSystem.vehicleType.VehicleType;

import java.util.List;
import java.util.Optional;

//4
public class ParkingFloor {
    private final int floorNo;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floorNo, List<ParkingSpot> spots) {
        this.floorNo = floorNo;
        this.spots = spots;
    }
    public synchronized Optional<ParkingSpot> getParkingSpot(VehicleType type){
        return spots.stream()
                .filter(spot -> spot.isAvailable() && spot.getType() == type)
                .findFirst();
    }
    public List<Integer> getAvailableSpots(VehicleType type){
        return spots.stream()
                .filter(spot -> spot.isAvailable() && spot.getType() == type)
                .map(spot -> spot.getSpotNo())
                .toList();
    }

    public int getFloorNo() {
        return floorNo;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
