package service;

import model.interfaces.Shippable;
import model.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    private double totalWeight=0;
    public ShippingService(Map<Shippable,Long> shippableItems){
        if(shippableItems.isEmpty()||shippableItems==null) {
            System.out.println("There are no items to ship");
            return;
        }
        System.out.println("\n** Shipment Notice **");


        for(Map.Entry<Shippable,Long> entry:shippableItems.entrySet()){
            Shippable product=entry.getKey();
            Long quantity=entry.getValue();
            double itemWeightValue=product.getWeight();
            double totalItemWeight=itemWeightValue*quantity;

            // assume that the weight is in kg
            System.out.printf("%dx %-15s %.0fg%n", quantity, product.getName(), totalItemWeight * 1000);
            totalWeight+=totalItemWeight;
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);

    }
}
