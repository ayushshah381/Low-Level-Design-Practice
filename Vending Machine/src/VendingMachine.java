public class VendingMachine {
    private static VendingMachine instance;
    Inventory inventory;
    private final IdleState idleState;
    private final ReadyState readyState;
    private final DispenseState dispenseState;
    private final ReturnChangeState returnChangeState;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private double totalPayment;

    public static synchronized VendingMachine getInstance() {
        if(instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public void setState(VendingMachineState state) {
        currentState = state;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public ReadyState getReadyState() {
        return readyState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public ReturnChangeState getReturnChangeState() {
        return returnChangeState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    void setSelectedProduct(Product product) {
        this.selectedProduct = product;
    }

    void resetSelectedProduct() {
        this.selectedProduct = null;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getCoinValue();
    }

    void addNote(Note note) {
        totalPayment += note.getNoteValue();
    }

    void resetPayment() {
        totalPayment = 0.0;
    }
}
