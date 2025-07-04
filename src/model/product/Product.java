package model.product;

public abstract class Product {
    private String name;
    private double price;
    private Long quantity;

    public Product(String name, double price, Long quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Long getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable(int requiredQuantity) {
        return this.quantity >= requiredQuantity;
    }

    public  void reduceQuantity(Long requiredQuantity){
        this.quantity -= requiredQuantity;
    }
}
