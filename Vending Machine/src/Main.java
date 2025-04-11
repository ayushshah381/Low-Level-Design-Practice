public class Main {
    public static void main(String[] args) {
        // Start with your own vending machine
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add a few products first
        Product chips = new Product("Lays", 10);
        Product coke = new Product("Coke", 20);
        Product chocolate = new Product("Chocolate", 7.5);

        vendingMachine.inventory.addProduct(chips, 10);
        vendingMachine.inventory.addProduct(coke, 12);
        vendingMachine.inventory.addProduct(chocolate, 40);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coins
        vendingMachine.insertNote(Note.TEN);
        vendingMachine.insertNote(Note.TWENTY);
        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.insertCoin(Coin.QUARTER);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return the change
        vendingMachine.returnChange();
    }
}