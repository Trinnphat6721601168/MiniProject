package Lib;
import java.util.ArrayList;
    /**
     * คลาสทำหน้าที่เป็นแคททาล้อกสินค้า (Repository)
     */
public class ProductCatalog {
    private ArrayList<Product> products=new ArrayList<>();

    //RI: product list is not null, contain no null element, and no duplicate products.
    //AF: AF(product) = A catalog of all available producrs.

    private void checkRep(){
         if(products == null){
            throw new RuntimeException("RI violated: product");
        }
        //Check for duplicate products
        for(int i=0;i<products.size();i++){
        for(int j=i+1;j<products.size();j++){
          if(products.get(i).equals(products.get(j))){
            throw new RuntimeException("RI violated: product");
          }
         }
        }
    }

    public ProductCatalog(){
        checkRep();
    }

    /**
     * เพิ่มสินค้าใหม่เข้าสู่แคททาล้อก
     * @param product สินค้าที่ต้องการเพิ่ม
     */
    public void addProduct(Product product){
    if(product!=null&&!products.contains(product)){
        products.add(product);
    }
    checkRep();}

    /**
     * ค้นหาสินค้าจากรหัสสินค้า
     * @param productID รหัสสินค้าที่ต้องการค้นหา
     * @return object Product หากพบ, หรือ null หากไม่
     */
    public Product findByID(String productID){
        for (Product p : products) {
            if(p.getProductID().equals(productID)){
                return p;
            }
        }
        return null;
    }
    
        
    

}

