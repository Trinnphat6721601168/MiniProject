package Lib;
public class CartItem {
    /**
    *  ADT(Mutable) สามารถปรับเปลี่ยนได้ สำหรับข้อมูลสินค้าเก็บสินค้าแต่ละรายการในตะกร้า
    */
    private final Product product;
    private int quantity;

    //RI:product ต้องไม่เป็น null,  quantity > 0
    //AF:AF(product,quantity)=A item in a shopping cart with given 'product' with the specified 'quantity'.

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if(product==null){
            throw new RuntimeException("RI violated: product cannot null");
        }
        if(quantity<=0){
            throw new RuntimeException("RI violated: quantity must be greater than zero");
        }
    }

    /**
     * สร้างรายการสินค้าในตะกร้า
     */
    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        checkRep();
    }

    /**
     * @return object product
     */
    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }

    /**
     * เมธอดเพิ่มจำนวนสินค้าในรายการ
     * @param amount จำนวนที่ต้องการเพิ่ม(ต้องมากกว่า 0)
     */
    public void increaseQuantity(int amount){
        if(amount > 0){
            this.quantity += amount;
        }
        checkRep();
    }
}
