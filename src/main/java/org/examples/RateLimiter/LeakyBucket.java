package org.examples.RateLimiter;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket {
    long capacity;
    double leakRate;
    Queue<Instant> bucket;
    Instant lastLeakTime;

    LeakyBucket(double leakRate ,long capacity){
        this.capacity = capacity;
        this.leakRate = leakRate;
        bucket = new LinkedList<>();
        lastLeakTime = Instant.now();
    }
    synchronized boolean allowRequest(){
        leak();

        if (bucket.size() < capacity) {
            bucket.offer(Instant.now());  // Add the new request to the bucket
            return true;  // Allow the request
        }
        return false;
    }

    private void leak() {
        Instant now = Instant.now();

        double leakedItems = (now.getEpochSecond() - lastLeakTime.getEpochSecond()) * leakRate;

        for(int i=0;i<leakedItems && !bucket.isEmpty();i++){
            bucket.poll();
        }

        lastLeakTime = now;
    }
}
