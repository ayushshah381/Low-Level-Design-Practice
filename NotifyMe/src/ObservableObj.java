public interface ObservableObj {
    public void addObserver(ObserverObj observer);

    public void removeObserver(ObserverObj observer);

    public void notifyAllObservers();

    public void setStockCount(int stockCount);

    public int getStockCount();
}
