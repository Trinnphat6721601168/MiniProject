package Lib.Discount;
import Lib.CartItem;
/**
 * การคิดราคาส่วนลด BULK (ซื้อเยอะลดเยอะ)
 */

public class BulkDiscountStrategy implements DiscountStrategy{
    private int minimunQuantity;
    private double discountPercentage;

    public BulkDiscountStrategy(int minimunQuantity, double discountPercentage){
        this.minimunQuantity = minimunQuantity;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(CartItem item) {
        double TotalPrice=item.getProduct().getPrice()*item.getQuantity();
        if(item.getQuantity()>=minimunQuantity)
        {
            return TotalPrice*(1.0-discountPercentage);

        }
        return TotalPrice;

    }
    
}
