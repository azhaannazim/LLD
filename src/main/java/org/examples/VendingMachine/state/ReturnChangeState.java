package org.examples.VendingMachine.state;

import org.examples.VendingMachine.Product;
import org.examples.VendingMachine.VendingMachine;
import org.examples.VendingMachine.currency.Coin;
import org.examples.VendingMachine.currency.Note;

public class ReturnChangeState implements VMState{
    private VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {

    }

    @Override
    public void insertCoin(Coin coin) {

    }

    @Override
    public void insertNote(Note note) {

    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getselectedProduct().getPrice();
        if (change > 0) {
            System.out.println("Change returned: $" + change);
        } else {
            System.out.println("No change to return.");
        }
        vendingMachine.resetVendingMachine();
    }
}
