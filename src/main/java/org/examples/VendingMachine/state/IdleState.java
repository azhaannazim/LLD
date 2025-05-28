package org.examples.VendingMachine.state;

import org.examples.VendingMachine.Product;
import org.examples.VendingMachine.VendingMachine;
import org.examples.VendingMachine.currency.Coin;
import org.examples.VendingMachine.currency.Note;

public class IdleState implements VMState{
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if(vendingMachine.getInventory().isAvailable(product)){
            System.out.println("selected product : " + product.getName());
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getPaymentState()); //transition to new state
        }
        else {
            System.out.println("Product not available: " + product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product and make payment.");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return.");
    }
}
