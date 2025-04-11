import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    public Map<Product, Integer> productList;

    public Inventory() {
        productList = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        productList.put(product, quantity);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public void updateQuantity(Product product, int newQuantity) {
        productList.put(product, newQuantity);
    }

    public int getProductQuantity(Product product) {
        return productList.getOrDefault(product, 0);
    }

    public boolean isProductAvailable(Product product) {
        return productList.containsKey(product) && productList.get(product) > 0;
    }

}
