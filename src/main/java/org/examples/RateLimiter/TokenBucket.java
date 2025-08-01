package org.examples.RateLimiter;

import java.time.Instant;

public class TokenBucket {
    long capacity;
    double fillingRate;
    double tokens;
    Instant lastRefillTime;

    TokenBucket(double fillingRate ,long capacity){
        this.capacity = capacity;
        this.fillingRate = fillingRate;
        this.tokens = capacity; //start full
        lastRefillTime = Instant.now();
    }
    synchronized boolean allowRequest(int required){
        refill();

        if(tokens >= required){
            tokens -= required;
            return true;
        }
        
        return false;
    }

    private void refill() {
        Instant now = Instant.now();

        double tokensAdded = (now.getEpochSecond() - lastRefillTime.getEpochSecond()) * fillingRate;

        tokens = Math.min(capacity , tokens + tokensAdded);

        lastRefillTime = now;
    }
}
