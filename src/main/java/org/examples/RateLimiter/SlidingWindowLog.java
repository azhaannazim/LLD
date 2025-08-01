package org.examples.RateLimiter;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog {
    long windowSize;
    long maxRequestsPerWindow;
    Queue<Long> window;

    public SlidingWindowLog(long windowSize, long maxRequestsPerWindow) {
        this.windowSize = windowSize;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        window = new LinkedList<>();
    }
    synchronized boolean allowRequest(){
        long now = Instant.now().getEpochSecond();
        long windowStart = now - windowSize;

        while(!window.isEmpty() && window.peek() <= windowStart){
            window.poll();
        }
        if(window.size() < maxRequestsPerWindow){
            window.offer(now);
            return true;
        }
        return false;
    }
}
