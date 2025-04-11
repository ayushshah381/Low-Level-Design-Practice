public interface VendingMachineState {
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void selectProduct(Product product);
    void dispenseProduct();
    void returnChange();
}
