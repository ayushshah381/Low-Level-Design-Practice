public class DispenseState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
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
        vendingMachine.setState(vendingMachine.getReadyState());

        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getProductQuantity(product) - 1);
        System.out.println("Product " + product + "Dispensed");
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {

    }
}
