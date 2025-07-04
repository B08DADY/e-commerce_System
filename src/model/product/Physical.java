package model.product;

import model.interfaces.Shippable;

public class Physical extends Product implements Shippable {
    private double weight;


    public Physical(String name, double price, int quantity,double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }


}
