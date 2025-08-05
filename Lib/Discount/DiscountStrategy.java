package Lib.Discount;
import Lib.CartItem;
/**
 * Interface สำหรับการคำนวนราคาสินค้า
 */
public interface DiscountStrategy {
    /**
     * คำนวนราคาสินค้าแต่ละรายการ
     * @param item รายการสินค้าในตะกร้า
     * @return ราคาหลังใช้โปรดมชั่น
     */
    double calculatePrice(CartItem item);
}
