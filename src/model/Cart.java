package model;

import model.product.Product;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartItems=new HashMap<>();
    public void addItem(Product product,int quantity){
        if(quantity<=0){
            System.out.println("Error: Invalid quantity, It must be greater than zero");
            return;
        }
        if(product==null){
            throw new IllegalArgumentException("Error: Product cannot be null");
        }
        if(!product.isAvailable(quantity)){
            System.out.println("Error: This product is out of stock with this quantity the available quantity is "+
                    product.getQuantity());
            return;
        }

        cartItems.put(product,cartItems.getOrDefault(product,0)+quantity);
    }

    public Map<Product, Integer> getCartItems() {
        return new HashMap<>(cartItems);
    }
    public boolean isEmpty(){
        return cartItems.isEmpty();
    }
    public void clearCart(){
        cartItems.clear();
    }
}
