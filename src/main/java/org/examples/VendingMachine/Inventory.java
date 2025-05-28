package org.examples.VendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map<Product , Integer> map;

    Inventory(){
        map = new ConcurrentHashMap<>();
    }
    public void addProduct(Product product ,int quantity){
        map.put(product , map.getOrDefault(product , 0) + quantity);
    }
    public void removeProduct(Product product) {
        map.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        map.put(product, quantity);
    }

    public int getQuantity(Product product) {
        return map.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product) {
        return map.containsKey(product) && map.get(product) > 0;
    }
}
