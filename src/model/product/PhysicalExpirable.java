package model.product;

import model.interfaces.Expirable;
import model.interfaces.Shippable;

import java.time.LocalDate;


public class PhysicalExpirable extends Product implements Expirable, Shippable {
    private double weight;
    private LocalDate expiryDate;
    public PhysicalExpirable( String name, double price, Long quantity, double weight, LocalDate expiryDate){
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expiryDate);
    }
    public double getWeight() {
        return weight;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

}
