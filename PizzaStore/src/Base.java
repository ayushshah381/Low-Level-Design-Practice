import java.math.BigDecimal;

public class Base implements OrderItem{
    private String name;
    private BigDecimal price;

    public Base(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
