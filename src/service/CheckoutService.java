package service;

import exception.EmptyCartException;
import exception.ExpiredException;
import exception.InsufficientBalanceException;
import model.Cart;
import model.Customer;
import model.interfaces.Shippable;
import model.product.PhysicalExpirable;

import model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutService {
    private Customer customer;
    private double shippingCost=0;
    private double subTotal=0;
    private double amount=0;


    private  Map<Shippable,Long> shippableItemsCount=new HashMap<>();
    private  Map<Product,Long> allItemsCount=new HashMap<>();

    public void checkout(Customer customer){
        this.customer=customer;
        Cart customerCart=customer.getCustomerCart();
        Map<Product, Long> cartItems=customerCart.getCartItems();

        // First check if the cart is empty
        if(customerCart.isEmpty()){
            throw new EmptyCartException("Chekout failed:The cart is empty");
        }

        for(Map.Entry<Product,Long> item:cartItems.entrySet()){
            Product product=item.getKey();
            Long quantity=item.getValue();

            // Second check if the product is Expired
            if(product instanceof PhysicalExpirable){
                if(((PhysicalExpirable) product).isExpired()){
                    throw new ExpiredException("Chekout failed:This product is expired");
                }
            }

            if(product instanceof Shippable){
                shippableItemsCount.put((Shippable)product
                        ,shippableItemsCount.getOrDefault((Shippable)product,0L)+quantity);
                shippingCost+=Shippable.shippingCost*quantity;
            }

            allItemsCount.put(product
                    ,allItemsCount.getOrDefault(product,0L)+quantity);


            subTotal+=product.getPrice()*quantity;

        }
        amount=subTotal+shippingCost;

       printCheckout();

    }
    public void printCheckout(){
        // Third check if total Amount is greater than the customer balance
        if(amount>customer.getBalance())
            throw new InsufficientBalanceException("Chekout failed:The total cost is greater than the Your balance");

        customer.subtractBalance(amount);

         ShippingService shipp=new ShippingService(shippableItemsCount);


        System.out.println("\n** Checkout Notice **");


        for(Map.Entry<Product,Long> item:allItemsCount.entrySet()) {

            Product product=item.getKey();
            Long quantity=item.getValue();
            System.out.printf("%dx %-15s %.0f%n", quantity, product.getName(), product.getPrice() * quantity);
            product.reduceQuantity(quantity);
        }
        System.out.println("--------------------");
        System.out.printf("%-18s %.0f%n", "Subtotal", subTotal);
        System.out.printf("%-18s %.0f%n", "Shipping", shippingCost);
        System.out.printf("%-18s %.0f%n", "Amount", amount);
        System.out.println("--------------------");
        System.out.printf("Customer Balance: %.2f%n", customer.getBalance());

    }



}
