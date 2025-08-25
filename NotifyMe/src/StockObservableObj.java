import java.util.ArrayList;
import java.util.List;

public class StockObservableObj implements ObservableObj{
    // List of all the observers
    List<ObserverObj> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void addObserver(ObserverObj observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(ObserverObj observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(ObserverObj observer: observerList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        if(this.stockCount == 0) {
            this.notifyAllObservers();
        }
        this.stockCount += stockCount;
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
