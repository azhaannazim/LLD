package org.examples.VendingMachine.state;

import org.examples.VendingMachine.Product;
import org.examples.VendingMachine.VendingMachine;
import org.examples.VendingMachine.currency.Coin;
import org.examples.VendingMachine.currency.Note;

public class PaymentState implements VMState{
    private final VendingMachine vendingMachine;

    public PaymentState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: " + coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted: " + note);
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first.");
    }

    private void checkPaymentStatus() {
        if (vendingMachine.getTotalPayment() >= vendingMachine.getselectedProduct().getPrice()) {
            vendingMachine.setState(vendingMachine.getDispenseState()); //state transition
        }
    }
}
