package org.examples.Hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ConsistentHashing {
    int numReplicas;
    TreeMap<Long , String> ring;
    Set<String> servers;

    public ConsistentHashing(List<String> serversList , int numReplicas) {
        this.numReplicas = numReplicas;
        ring = new TreeMap<>();
        servers = new HashSet<>();

        for(String s : serversList){
            addServer(s);
        }
    }
    private long hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            return ((long) (digest[0] & 0xFF) << 24) |
                    ((long) (digest[1] & 0xFF) << 16) |
                    ((long) (digest[2] & 0xFF) << 8) |
                    ((long) (digest[3] & 0xFF));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
    void addServer(String server){
        servers.add(server);
        for(int i=0;i<numReplicas;i++){
            long hash = hash(server + "-" + i);

            ring.put(hash , server);
        }
    }
    void remove(String server){
        if(servers.remove(server)){
            for (int i=0;i<numReplicas;i++){
                long hash = hash(server + "-" + i);

                ring.remove(hash);
            }
        }
    }

    String getServer(String key){
        if(ring.isEmpty()) return null;

        long hash = hash(key);

        Long ceil = ring.ceilingKey(hash);
        if(ceil == null){
            return ring.get(ring.firstKey());
        }
        return ring.get(ceil);
    }
    public static void main(String[] args) {
        List<String> servers = Arrays.asList("S0", "S1", "S2", "S3", "S4", "S5");
        ConsistentHashing ch = new ConsistentHashing(servers, 3);

        System.out.println("UserA is assigned to: " + ch.getServer("UserA"));
        System.out.println("UserB is assigned to: " + ch.getServer("UserB"));

        ch.addServer("S6");
        System.out.println("UserA is now assigned to: " + ch.getServer("UserA"));

        ch.remove("S2");
        System.out.println("UserB is now assigned to: " + ch.getServer("UserB"));
    }


}
