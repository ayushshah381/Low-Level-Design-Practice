public class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getProductName() {
        return name;
    }

    public double getProductPrice() {
        return price;
    }
}
