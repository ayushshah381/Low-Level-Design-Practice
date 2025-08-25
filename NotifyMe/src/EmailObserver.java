public class EmailObserver implements ObserverObj{
    StockObservableObj stockObservableObj;
    String emailId;

    public EmailObserver(String emailId, StockObservableObj stockObservableObj) {
        this.emailId  = emailId;
        this.stockObservableObj = stockObservableObj;
    }

    @Override
    public void update() {
        // Once the observable triggers a notify, send an update to this emailId
        System.out.println("An email has been sent to: " + this.emailId);
    }
}
