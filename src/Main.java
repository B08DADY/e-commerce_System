import model.Cart;
import model.Customer;
import model.interfaces.Expirable;

import model.product.Physical;
import model.product.PhysicalExpirable;
import model.product.Product;
import service.CheckoutService;

import java.time.LocalDate;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Amr", 1000);
        CheckoutService checkoutService=new CheckoutService();
        Cart cart=customer.getCustomerCart();



        Product cheese= new PhysicalExpirable("Cheese",10,100L,0.2, LocalDate.now().plusDays(20));
        Product biscuits= new PhysicalExpirable("Biscuits",10,100L,0.7, LocalDate.now().plusDays(20));
        cart.addItem(cheese,2);
        cart.addItem(biscuits,1);

        cart.clearCart();
        checkoutService.checkout(customer);





    }
}