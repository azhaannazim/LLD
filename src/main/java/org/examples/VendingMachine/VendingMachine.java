package org.examples.VendingMachine;

import org.examples.VendingMachine.currency.Coin;
import org.examples.VendingMachine.currency.Note;
import org.examples.VendingMachine.state.*;

public class VendingMachine {
    private static VendingMachine instance;
    Inventory inventory;

    private final VMState idleState;
    private final VMState paymentState;
    private final VMState dispenseState;
    private final VMState returnChangeState;

    private VMState currentState;
    private Product selectedProduct;
    private double totalPayment;

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        paymentState = new PaymentState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);

        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }
    public Product addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price);
        inventory.addProduct(product, quantity);
        return product;
    }
    public void selectProduct(Product product){
        currentState.selectProduct(product);
    }
    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }
    public void insertNote(Note note){
        currentState.insertNote(note);
    }
    public void dispenseProduct(){
        currentState.dispenseProduct();
    }
    public void returnChange(){
        currentState.returnChange();
    }

    public  void setState(VMState state) {
        currentState = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public VMState getIdleState() {
        return idleState;
    }

    public VMState getPaymentState() {
        return paymentState;
    }

    public VMState getDispenseState() {
        return dispenseState;
    }

    public VMState getReturnChangeState() {
        return returnChangeState;
    }

    public Product getselectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    public void resetVendingMachine(){
        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }
    public double getTotalPayment() {
        return totalPayment;
    }
    public void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }
    public void addNote(Note note) {
        totalPayment += note.getValue();
    }
}
