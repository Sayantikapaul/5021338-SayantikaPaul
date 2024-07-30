
import java.util.*;

class Product {          //creating a datatype'Product'using collection od datatypes 
  public String productName;
  public int quantity;
  public int price;

  Product(String productName, int quantity, int price)
  {
    this.productName=productName;
    this.quantity=quantity;
    this.price=price;
  }
}

class ProductSystem {
  public ArrayList<Product> products;

  ProductSystem() {
    products=new ArrayList<>();
  }
  //1.Add
  public void addProduct(String productName, int quantity,int price)
  {
    products.add(new Product(productName,quantity,price));
    System.out.println("Product added succesfully");
  }

  //2.Update
  public void Updateproduct(int productId) {
    if(productId>=products.size())
    {
      System.out.println("can't Update the details");
    }
    else{
      Product product = products.get(productId);
      Scanner SC=new Scanner(System.in);
      System.out.println("UPDATE DETAILS ACCORDINGLY: ");
      System.out.println("1. Product Name");
      System.out.println("2. Product Quantity");
      System.out.println("3. Product Price");
      System.out.println("4. Update All");
      
      System.out.println("Enter the choice: ");
      int ch=SC.nextInt();

      switch (ch) {
        case 1:
            SC.nextLine();
            System.out.println("Enter the product name: ");
            String updatedProductName= SC.nextLine();
            product.productName=updatedProductName;
            break;
        case 2:
            System.out.println("Enter the product quantity: ");
            int updatedProductQuantity= SC.nextInt();
            product.quantity=updatedProductQuantity;
            break;
        case 3:
            System.out.println("Enter the product price: ");
            int updatedProductPrice= SC.nextInt();
            product.price=updatedProductPrice;
            break;
        case 4:
            SC.nextLine();
            System.out.println("Enter the product name: ");
            updatedProductName= SC.nextLine();
            product.productName=updatedProductName;
            
            System.out.println("Enter the product quantity: ");
            updatedProductQuantity= SC.nextInt();
            product.quantity=updatedProductQuantity;

            System.out.println("Enter the product price: ");
            updatedProductPrice= SC.nextInt();
            product.price=updatedProductPrice;
            break;
        default:
            System.out.println("Oops!Wrong can't Update");
      }//switch close
    }//else close

  }
  
  //3.Delete
  public void deleteProduct(int productId){
    if(productId>=products.size())
    {
      System.out.println("Can't update the details");
    }
    else{
      Product product=products.get(productId);
      System.out.println("Deleted Product");
      System.out.println("Product ID: "+productId);
      System.out.println("Product Name: "+product.productName);
      System.out.println("Product Quantity: "+product.quantity);
      System.out.println("Product Price: "+product.price);
      System.out.println();
      System.out.println("Product Deleted Successfully");
      products.remove(productId);
    }
  }

  //4.Display
  public void displayProducts()
  {
    for(int i=0;i<products.size();i++)
    {
      Product product=products.get(i);
      System.out.println("Product ID: "+i);
      System.out.println("Product Name: "+product.productName);
      System.out.println("Product Quantity: "+product.quantity);
      System.out.println("Product Price: "+product.price);

    }
  }
}


public class Pmain {      
  public static void main(String[] args) {
      ProductSystem productSystem=new ProductSystem();
      while(true){
        Scanner SC= new Scanner(System.in);
        System.out.println("INVENTORY MANAGEMENT SYSTEM");
        System.out.println("1.Add");
        System.out.println("2.Update");
        System.out.println("3.Delete");
        System.out.println("4.print");
        System.out.println("5.Exit");

        System.out.println("Enter the choice: ");
        int ch=SC.nextInt();
        switch (ch) {
            case 1:
              SC.nextLine();
              System.out.println("Enter the Product Name: ");
              String productName=SC.nextLine();

              System.out.println("Enter the Product Quantity: ");
              int quantity=SC.nextInt();

              System.out.println("Enter the Product Price: ");
              int price=SC.nextInt();

              productSystem.addProduct(productName,quantity,price);
              break;
            
            case 2:
              System.out.println("Enter the ProductID");
              int ProductID=SC.nextInt();
              productSystem.Updateproduct(ProductID);
              break;
            
            case 3:
              System.out.println("Enter the ProductID");
              ProductID=SC.nextInt();
              productSystem.deleteProduct(ProductID);
              break;
              
            case 4:
              productSystem.displayProducts();
              break;
            
            case 5:
              System.exit(0);
        
            default:
                System.out.println("Ops! Wrong Choice");
        }
      }
  }

  
}