
public class Product {
   
    //Declarations
    private String ProductCode = "" ; 
    private String ProductName = "" ; 
    private String ProductCategory = "" ;
    private String ProductWarrenty = "" ;
    private String ProductSupplier = "" ;
    private double ProductPrice = 0 ;
    private int StockLevel = 0 ;
   
           
    // Get and set methods for PRODUCT
    public void setProductCode(String ProductCode) {
        this.ProductCode = ProductCode;}
     public String getProductCode() {
        return ProductCode;}
     
     public void setProductName(String ProductName) {
        this.ProductName = ProductName;}
     public String getProductName() {
        return ProductName;}

     public void setProductCategory(String ProductCategory) {
        this.ProductCategory = ProductCategory;}
     public String getProductCategory() {
        return ProductCategory;}

     public void setProductWarrenty(String ProductWarrenty) {
        this.ProductWarrenty = ProductWarrenty;}
     public String getProductWarrenty() {
        return ProductWarrenty;}

     public void setProductSupplier(String ProductSupplier) {
        this.ProductSupplier = ProductSupplier;}
     public String getProductSupplier() {
        return ProductSupplier;}

      public void setProductPrice (double ProductPrice ) {
        this.ProductPrice  = ProductPrice ;}
     public double getProductPrice () {
        return ProductPrice ;}

     public void setStockLevel (int StockLevel ) {
        this.StockLevel  = StockLevel ;}
     public int getStockLevel () {
        return StockLevel ;}
     
     
     
}
