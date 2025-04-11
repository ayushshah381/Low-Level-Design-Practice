public class IdleState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Select a product first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Select a product first");
    }

    @Override
    public void selectProduct(Product product) {
        if(this.vendingMachine.inventory.isProductAvailable(product)) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState());
            System.out.println("Product selected: "+product.getProductName());
        }
        else {
            System.out.println("Product "+product.getProductName()+" is not available");
        }
    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {

    }
}
