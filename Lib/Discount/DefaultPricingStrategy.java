package Lib.Discount;
import Lib.CartItem;
/**
 * การคิดราคาปกติ (ไม่มีส่วนลด)
 */
public class DefaultPricingStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(CartItem item) {
       return item.getProduct().getPrice() * item.getQuantity();
    }
    
}
