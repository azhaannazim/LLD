package org.examples.Lift;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int id;
    private int capacity;

    private int currentFloor;
    private Direction direction;
    private List<Request> requestList;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.direction = Direction.IDLE;
        requestList = new ArrayList<>();
    }
    public synchronized void addRequest(Request request){
        if (requestList.size() < capacity) {
            requestList.add(request);
            System.out.println("Elevator " + id + " added request: " + request);
            notifyAll();
        }
    }
    public synchronized Request getNextRequest() {
        while (requestList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return requestList.removeFirst();
    }
//    keeps checking for requests and moves accordingly
    public void processRequests() {
        while (true) {
            Request request = getNextRequest(); // already blocks
            processRequest(request);

            synchronized (this) {
                if (requestList.isEmpty()) direction = Direction.IDLE;
            }
        }
    }

    private void processRequest(Request request) {
        moveTo(request.getSourceFloor());
        moveTo(request.getDestinationFloor());

        synchronized (this) {
            if (requestList.isEmpty()) direction = Direction.IDLE;
        }
    }
    private void moveTo(int targetFloor) {
        if (currentFloor == targetFloor) return;

        direction = targetFloor > currentFloor ? Direction.UP : Direction.DOWN;
        int step = direction == Direction.UP ? 1 : -1;

        while (currentFloor != targetFloor) {
            currentFloor += step;
            System.out.println("Elevator " + id + " reached floor " + currentFloor);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        processRequests();
    }

    public synchronized boolean isAvailable(){
        return capacity > requestList.size();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}
