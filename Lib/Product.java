package Lib;
public final class Product {
    /**
     * ADT(Immutable)ไม่สามารถปรับเปลี่ยนได้ สำหรับข้อมูลสินค้า
     */

    private final String productID;
    private final String productName;
    private final double price;
    
    //RI:productID , productName ต้องไม่เป็นค่าว่าง(null/blank) ,price > 0
    //AF:AF(productID, productName, price) = A product with the given ID, Name and price.

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */

    private void checkRep(){
        if (productID == null || productID.isBlank()) {
            throw new RuntimeException("RI violated: productID");
        }
        if (productName == null || productName.isBlank()) {
            throw new RuntimeException("RI violated: productName");
        }
        if (price < 0 ) {
            throw new RuntimeException("RI violated: productID");
        }
    }

    /**
     * 
     * @param productID รหัสสินค้า ห้ามเป็นค่าว่าง
     * @param productName ชื่อสินค้า ห้ามเป็นค่าว่าง
     * @param price ราคา ห้ามติดลบ
     */
    public Product (String productID, String  productName, double price){
        this.productID = productID;
        this.productName = productName;
        this.price =  price ;
        checkRep();
        }
    
    public String getProductID(){
        return productID;
    }
    public String getProductName(){
        return productName;
    }
    public double getPrice(){
        return price;
    }
     /**
     * เปรียนเทียบ Product สองขึ้นไปโดยใช้ productId
     * @param obj object ที่ต้องการเปรียบเทียบ
     * @return true หาก productID เหมือนกัน
     */
    
     @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; 
        Product product = (Product) obj;
        return productID.equals(product.productID);
    }

}
