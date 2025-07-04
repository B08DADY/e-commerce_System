package model.product;

import model.interfaces.Expirable;
import model.interfaces.Shippable;

import java.util.Date;

public class PhysiclaExpirable extends Product implements Expirable, Shippable {
    private double weight;
    private Date expiryDate;
    public PhysiclaExpirable( String name, double price, int quantity, double weight, Date expiryDate){
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }
    @Override
    public boolean isExpired() {
        return new Date().after(expiryDate);
    }
    public double getWeight() {
        return weight;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public String getName() {
        return getName();
    }


}
