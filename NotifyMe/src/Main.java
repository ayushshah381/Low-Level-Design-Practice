public class Main {
    public static void main(String[] args) {
        StockObservableObj stockObservableObj = new StockObservableObj();

        // Add observers
        EmailObserver obs1 = new EmailObserver("abc@gmail.com", stockObservableObj);
        EmailObserver obs2 = new EmailObserver("xyz@gmail.com", stockObservableObj);

        stockObservableObj.addObserver(obs1);
        stockObservableObj.addObserver(obs2);

        // update the stock count in observable, and check if the update is triggered in observer
        stockObservableObj.setStockCount(10);

        // decrease the stock counts till 0
        stockObservableObj.setStockCount(-10);

        // check if it is triggered again
        stockObservableObj.setStockCount(20);
    }
}