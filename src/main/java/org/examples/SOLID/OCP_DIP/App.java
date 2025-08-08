package org.examples.SOLID.OCP_DIP;

public class App {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.process(new CreditCard() , 100);
        processor.process(new UPI() , 90);
    }
}
