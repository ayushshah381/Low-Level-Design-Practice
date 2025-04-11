public class ReturnChangeState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Coin coin) {

    }

    @Override
    public void insertNote(Note note) {

    }

    @Override
    public void selectProduct(Product product) {

    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getProductPrice();
        if(change > 0) {
            System.out.println("Change returned: " + change);
        }
        else {
            System.out.println("No change to return");
        }

        vendingMachine.resetPayment();
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
