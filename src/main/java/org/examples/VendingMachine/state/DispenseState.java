package org.examples.VendingMachine.state;

import org.examples.VendingMachine.Product;
import org.examples.VendingMachine.VendingMachine;
import org.examples.VendingMachine.currency.Coin;
import org.examples.VendingMachine.currency.Note;

public class DispenseState implements VMState{
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.getselectedProduct();
        int quantity = vendingMachine.getInventory().getQuantity(product);

        vendingMachine.getInventory().addProduct(product , quantity - 1);
        System.out.println("Product dispensed: " + product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState()); // transition to ReturnChangeState
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }
}
