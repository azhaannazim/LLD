package org.examples.VendingMachine.state;

import org.examples.VendingMachine.Product;
import org.examples.VendingMachine.currency.Coin;
import org.examples.VendingMachine.currency.Note;

public interface VMState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
}
