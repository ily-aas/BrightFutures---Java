import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    //Global object and arraylist used in multiple methods
    static Scanner inputDevice = new Scanner(System.in);
    static ArrayList<Product> ProductList = new ArrayList<Product>();
  
    public static void main(String[] args){
         //Start up screen that ask the user to run the program
         int one = 0; 
         
         Scanner inputDevice = new Scanner(System.in);
         System.out.println("---------------------------------------------------------\n"
                 + "    | BRIGHT FUTURE TECHNOLOGIES STOCKTAKING SYSTEM |\n"
                 + "---------------------------------------------------------\n"
                 + "Enter (1) to launch menu or any other number to exit");
         
        if (inputDevice.hasNextInt()) {
           one = inputDevice.nextInt();
         } else {
            System.out.println("Invalid input. Please enter a number.");
             System.exit(0);
         }
        
         if (one == 1)
             LaunchMenu();
         else 
             System.exit(0);
        }         
    
    //Launches the menu that gives the user options to perform an action
    public static void LaunchMenu(){
     
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n"
                    + "                   MENU \n"
                    + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        
        try {
            int MenuSelect = 0;

            System.out.println(" Please select one of the following menu items : ");
            System.out.println(" (1) Capture a new product.");
            System.out.println(" (2) Search for a product.");
            System.out.println(" (3) Update a product.");
            System.out.println(" (4) Delete a product.");
            System.out.println(" (5) Print report. ");
            System.out.println(" (6) Exit application.");

            if (inputDevice.hasNextInt()) {
                MenuSelect = inputDevice.nextInt();
                // Validate the input range
                if (MenuSelect < 1 || MenuSelect > 6) {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    // Clear the invalid input from the scanner
                    inputDevice.nextLine();
                    // Prompt the user again
                    LaunchMenu();
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                // Clear the invalid input from the scanner
                inputDevice.nextLine();
                // Prompt the user again
                LaunchMenu();
            }

            // Runs the methods 
            switch (MenuSelect) {

                case 1:
                    CaptureProduct();
                    break;

                case 2:
                    SearchProduct();
                    break;

                case 3:
                    UpdateProduct();
                    break;

                case 4:
                    DeleteProduct();
                    break;

                case 5:
                    PrintReport();
                    break;

                case 6:
                    System.exit(0);
                    break;
            }
    } catch (Exception e) {
        
        e.printStackTrace();
    }
   
}
    
    
     //Captures products and stores them in an array list
     public static void CaptureProduct(){
               
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n"
                    + "                CAPTURE A PRODUCT \n"
                    + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");

        //Declarations + Objects created

        String cpProductName;
        int warControl = 0;
        int catControl =  0 ; 
        Scanner inputDevice = new Scanner(System.in);
        Product Product = new Product();

        //Captures the product code
        System.out.println(" Enter the product code ");          
        Product.setProductCode( inputDevice.next()); 
        
        //Captures product name
        System.out.println(" Enter the product name ");
        while (!inputDevice.hasNext("[a-zA-Z]+")) {
            System.out.println("Invalid input. Please enter a valid product name (only letters):");
            inputDevice.next(); // Consume the invalid input
        }
        cpProductName = inputDevice.next();
        Product.setProductName(cpProductName);
        
        //Prompts the user to select a category
        System.out.println(" Select the product category ");
        System.out.println(" Desktop Computer - 1 ");
        System.out.println(" Laptop - 2 ");
        System.out.println(" Tablet - 3 ");
        System.out.println(" Printer - 4");
        System.out.println(" Gaming concsole - 5 ");

         //sets the product category
         // Validate input to ensure only integers between 1 and 5 are entered
         while (true) {
            System.out.println("Enter a number between 1 and 5:");

            if (inputDevice.hasNextInt()) {
                catControl = inputDevice.nextInt();

                if (catControl >= 1 && catControl <= 5) {
                    // Valid input, break out of the loop
                    break;
                } else {
                    System.out.println("Please enter a valid number between 1 and 5");
                }
            } else {
                System.out.println("Please enter a valid number");
                // Consume the invalid input
                inputDevice.next();
            }
        }
        
        switch(catControl){
            case 1:
                    System.out.println(" Product Category >> 1 ");
                    Product.setProductCategory("Desktop Computer");
            break; 

            case 2:
                    System.out.println(" Product Category >> 2 ");
                    Product.setProductCategory("Laptop");
                    break; 

            case 3:
                    System.out.println(" Product Category >> 3 ");
                    Product.setProductCategory("Tablet ");
                    break; 

            case 4:
                    System.out.println(" Product Category >> 4 ");
                     Product.setProductCategory("Printer ");
                    break; 

            case 5:
                    System.out.println(" Product Category >> 5 ");
                     Product.setProductCategory("Gaming Console "); 
                    break; }

        //User input for warrenty
        System.out.println(" Indicate the product warrenty. Enter (1) for 6 months or (2) for 2 years ");
         
    while (true) {
    if (inputDevice.hasNextInt()) {
        warControl = inputDevice.nextInt();
        if(warControl == 1 ){
            Product.setProductWarrenty("6 months");
            break;
        }else if(warControl == 2){
            Product.setProductWarrenty("2 years");
            break;
        }
        // Continue with other logic if needed after processing the input
    } else {
        System.out.println("Please enter a valid number");
        // Consume the invalid input
        inputDevice.next();
    }
}
 
        //Price
        System.out.println(" Enter the price for " + Product.getProductName() + " in rands >> ");
         while (!inputDevice.hasNextDouble()){
            System.out.println("Invalid input. Please enter a valid price:");
            inputDevice.next(); // Consume the invalid input
        }
        Product.setProductPrice(inputDevice.nextDouble()); 

        //Stock level
        System.out.println(" Enter the stocklevel for " + Product.getProductName() + " >> ");
         while (!inputDevice.hasNextInt()){
            System.out.println("Invalid input. Please enter a valid stock level:");
            inputDevice.next(); // Consume the invalid input
        }
        Product.setStockLevel(inputDevice.nextInt());

        //Supplier
        System.out.println(" Enter the supplier for " + Product.getProductName() + " >> ");
        Product.setProductSupplier(inputDevice.next());


        //Screen exit + menu relaunch
        System.out.println(" Product details have been saved sucessfully!!! ");



        //Adds updated product to Array list
        //System.out.println(Product.getProductCategory());
        ProductList.add(Product);
        //  System.out.println(ProductList);

       // Gives the user the option to return to menu or exit the application
       LaunchMenu();


 }


public static void SearchProduct(){
    
    //Declrations +
    String TestProdControl = "";
    boolean productFound = false;
    
    //Asking the user to enter a code which will be searched 
    System.out.println("Please enter the product code to search : ");
    TestProdControl = inputDevice.next();
    
    //Search algorithm used to find the matching product code entered previously
    for (int i = 0; i < ProductList.size(); i++){
        if(TestProdControl.equals(ProductList.get(i).getProductCode())){
            
              productFound = true;
            
              System.out.println("************************************************************");
              System.out.println("PRODUCT SEARCH RESULTS ");
              System.out.println("************************************************************");
              System.out.println("PRODUCT CODE :     " +ProductList.get(i).getProductCode());
              System.out.println("PRODUCT NAME :     " +ProductList.get(i).getProductName());
              System.out.println("PRODUCT CATEGORY : " +ProductList.get(i).getProductCategory());
              System.out.println("PRODUCT WARRANTY : " +ProductList.get(i).getProductWarrenty());
              System.out.println("PRODUCT PRICE :    " +ProductList.get(i).getProductPrice());
              System.out.println("PRODUCT STOCK LEVEL :    " +ProductList.get(i).getStockLevel());
              System.out.println("PRODUCT SUPPLIER : " +ProductList.get(i).getProductSupplier());
              System.out.println("************************************************************");}
        
    }
    
    if (!productFound) {
    System.out.println("No results found for the given product code.");
    LaunchMenu();  
    }

    LaunchMenu();
    
}


public static void UpdateProduct(){
    
    //Declarations
    boolean productFound = false;
    int warControl = 0;
    String Decision = "";
    int UpControl = 0;
    String UpdProdControl = "";
    
     //Asking the user to enter a code which will be searched
    System.out.println("Please enter the product code to update : ");
    UpdProdControl = inputDevice.next();
    
    for (int i = 0; i < ProductList.size(); i++){
        if(UpdProdControl.equals(ProductList.get(i).getProductCode())){
            
             productFound = true;
            
            //Ask the user if they want to update the warrenty
            System.out.println(" Indicate the product warrenty. Enter (1) for 6 months or (2) for 2 years ");
            while (true) {
                if (inputDevice.hasNextInt()) {
                    warControl = inputDevice.nextInt();
                    if(warControl == 1 ){
                        ProductList.get(i).setProductWarrenty("6 months");
                        break;
                    }else if(warControl == 2){
                        ProductList.get(i).setProductWarrenty("2 years");
                        break;
                    }
                // Continue with other logic if needed after processing the input
                } else {
                    System.out.println("Please enter a valid number. Enter (1) for 6 months or (2) for 2 years");
                    // Consume the invalid input
                    inputDevice.next();
                }
            }
            
            
            //Ask the user if they want to update the product price    
            System.out.println("Enter the new price for " + ProductList.get(i).getProductName() + " >> ");
            while (!inputDevice.hasNextDouble()){
             System.out.println("Invalid input. Please enter a valid price:");
             inputDevice.next(); // Consume the invalid input
            }
            ProductList.get(i).setProductPrice(inputDevice.nextDouble()); 
            
            
            //Ask the user if they want to update the product stock level            
            System.out.println("Enter the new stock level for " + ProductList.get(i).getProductName() + ">>");                
            while (!inputDevice.hasNextInt()){
            System.out.println("Invalid input. Please enter a valid stock level:");
            inputDevice.next(); // Consume the invalid input
            }
            ProductList.get(i).setStockLevel(inputDevice.nextInt());
            
            System.out.println("Details saved successfully!");    
            
        }
      
    }
 
    if (!productFound) {
    System.out.println("No results found for the given product code.");
    LaunchMenu();  
    }
    
    LaunchMenu();
}



public static void DeleteProduct(){
    
    //Declarations
    boolean productFound = false;
    String DecisionCheck = "";
    String DelProdControl = "";
    
    //Asking the user to enter a code which will be searched then deleted
    System.out.println("Please enter the product code to delete : ");
    DelProdControl = inputDevice.next();
   
    for (int i = 0; i < ProductList.size(); i++){
         if(DelProdControl.equals(ProductList.get(i).getProductCode())){
             
              productFound = true;
             
             System.out.println(" Would you like to delete " + ProductList.get(i).getProductName() + "? (y) Yes, (n) No  ");
               DecisionCheck = inputDevice.next();
                 if( DecisionCheck.equals("y")){
                          ProductList.remove(i);}       
        
         }
    }
    
    if (!productFound) {
    System.out.println("No results found for the given product code.");
    LaunchMenu();  
    }
  
    LaunchMenu();
}
    
    


public static void PrintReport(){
   
    //Declarations
    int ProdCount = 1;
    double SumProdVal = 0;
    
    System.out.println("PRODUCT REPORT ");
    System.out.println("--------------------------------------------------------");
    System.out.println("--------------------------------------------------------");
   
    //loops through the array list and displays the fields
    for (int i = 0; i < ProductList.size(); i++) {
         System.out.println("PRODUCT " + ProdCount);   
         System.out.println("--------------------------------------------------------");
         System.out.println("PRODUCT CODE >> "     +ProductList.get(i).getProductCode());
         System.out.println("PRODUCT NAME >> "     +ProductList.get(i).getProductName());
         System.out.println("PRODUCT CATEGORY >> " +ProductList.get(i).getProductCategory());
         System.out.println("PRODUCT WARRANTY >> " +ProductList.get(i).getProductWarrenty());
         System.out.println("PRODUCT PRICE >> "    +ProductList.get(i).getProductPrice());
         System.out.println("PRODUCT LEVEL >> "    +ProductList.get(i).getStockLevel());
         System.out.println("PRODUCT SUPPLIER "    +ProductList.get(i).getProductSupplier());
         System.out.println("--------------------------------------------------------");
         System.out.println(""); 
   
         ProdCount++; //Incements the product count displayed in the for loop
         SumProdVal += ProductList.get(i).getProductPrice(); // the sum of the prices of each product
        
   
    }
    
          
        System.out.println("--------------------------------------------------------");
        System.out.println("--------------------------------------------------------");
        System.out.println(" TOTAL PRODUCT COUNT: " + ProductList.size());
        System.out.println(" TOTAL PRODUCT VALUE: " + "R" + SumProdVal);
        System.out.println(" AVERAGE PRODUCT VALUE: " + "R" +SumProdVal/ProductList.size());
        System.out.println("--------------------------------------------------------");
        System.out.println("--------------------------------------------------------");
        
        LaunchMenu();

}//PrintReport
    
/* public static void SystemExit(){ //Used in most methods to exit the appliction or return to the menu
     
     int ExControl = 0;
     
     System.out.println(" Enter (1) to launch menu or any other key to exit ");
     ExControl = inputDevice.nextInt();
     
     if (ExControl == 1)
         LaunchMenu();
     else
         System.exit(0);
 
 }*/
   
}//Main method




