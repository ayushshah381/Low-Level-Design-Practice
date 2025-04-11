public class ReadyState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    private void checkPaymentStatus() {
        if(vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getProductPrice()) {
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: "+ coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted: "+ note);
        checkPaymentStatus();
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product selected...please make the payment");
    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {

    }
}
