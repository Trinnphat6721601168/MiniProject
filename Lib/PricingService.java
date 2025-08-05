package Lib;
import java.util.ArrayList;
import Lib.Discount.*;

/**
 * คลาสที่ทำหน้าจัดการโปรโมชั่น
 */

public class PricingService {
    private record StrategyRule(String sku,  DiscountStrategy strategy) {}
    private final  ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final DiscountStrategy defualtStrategy = new DefaultPricingStrategy();

    /**
     * ลงทะเบียนส่วนลดสินค้าสำหรับ sku ที่กำหนด
     * หากมีโปรโมชั่นสำหรับ sku อยู่แล้วจะถูกแทนที่ด้วยอันใหม่
     * @param sku รหัสสินค้าที่ต้องงการผูกกับโปรโมชั่น, strategy กลยุทธ์ส่วนลดที่ะให้
     */

     public void addStrategy(String sku, DiscountStrategy strategy){
        StrategyRule ruleToRemove = null;
        for (StrategyRule rule : strategies) {
            if(rule.sku().equals(sku)){
                ruleToRemove=rule;
                break;
            }
        }if (ruleToRemove!=null) {
            strategies.remove(ruleToRemove);
        }
        strategies.add(new StrategyRule(sku, strategy));
     }

     /**
      * คำนวนราคาของสินค้า 1 รายการโดยใช้กลยุทธ์ส่วนลดที่เหมาะสม
      * @param item รายการสินค้าที่ต้องการคำนวนราคา
      * @return ราคาหลังหักจากส่วนลด
      */

      public double calculateItemPrice(CartItem item){
        String sku = item.getProduct().getProductID();
        for (StrategyRule rule : strategies) {
            if (rule.sku().equals(sku)) {
                return rule.strategy().calculatePrice(item);
            }
        }
        return defualtStrategy.calculatePrice(item);
      }
}
