package model;

import service.CheckoutService;

public class Customer {
    private String name;
    private double balance;
    private Cart customerCart=new Cart();

    public Customer(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Cart getCustomerCart() {
        return customerCart;
    }

    public double getBalance() {
        return balance;
    }
    public void subtractBalance(double amount) {

        this.balance -= amount;
    }
}
