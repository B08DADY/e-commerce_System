package model.interfaces;

public interface Shippable {

    // let's assume shipping cost is 10$ for all physical products
    double shippingCost = 10;

    public double getWeight();
    public String getName();
}
