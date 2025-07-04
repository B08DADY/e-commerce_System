import model.Cart;
import model.Customer;
import model.interfaces.Expirable;

import model.product.Digital;
import model.product.Physical;
import model.product.PhysicalExpirable;
import model.product.Product;
import service.CheckoutService;

import java.time.LocalDate;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Amr", 100000);
        CheckoutService checkoutService=new CheckoutService();
        Cart cart=customer.getCustomerCart();


        /// 1# Scenario checkout done successfully
//            Product cheese= new PhysicalExpirable("Cheese",100,100,0.2, LocalDate.now().plusDays(20));
//            Product biscuits= new PhysicalExpirable("Biscuits",10,100,0.7, LocalDate.now().plusDays(20));
//            Product scratchCard= new Digital("ScratchCard",100,100);
//            cart.addItem(cheese,2);
//            cart.addItem(cheese,3);
//            cart.addItem(biscuits,5);
//            cart.addItem(scratchCard,10);
//            cart.addItem(scratchCard,5);
//            checkoutService.checkout(customer);
//            cart.clearCart();

        /// 2# Scenario checkout failed  because of expired product
//            Product milk= new PhysicalExpirable("Milk",10,100,0.5, LocalDate.now().minusDays(20));
//            Product sugar= new Physical("tv",10000,100,0.7);
//            cart.addItem(milk,2);
//            cart.addItem(sugar,1);
//            checkoutService.checkout(customer);
//            cart.clearCart();

        /// 3# Scenario checkout failed because of insufficient balance
//            Product scratchCard= new Digital("ScratchCard",10000000,100);
//            cart.addItem(scratchCard,1);
//            checkoutService.checkout(customer);
//            cart.clearCart();

        /// 4# Scenario checkout failed because of empty cart
//            checkoutService.checkout(customer);


        /// 5# Invalid amount of quantity
//            Product pen= new Physical("Pen",10,100,0.1);
//            cart.addItem(pen,0);
//            checkoutService.checkout(customer);
//            cart.clearCart();

        /// 6# quantity required is greater than available quantity
//            Product paper= new Physical("Paper",10,100,0.1);
//            cart.addItem(paper,1000);
//            checkoutService.checkout(customer);
//            cart.clearCart();

        /// 7# Product is null
//            Product nullProduct=null;
//            cart.addItem(nullProduct,1);
//            checkoutService.checkout(customer);




                                        /// I Can not Wait to be Part of the Team :DDDD
    }
}