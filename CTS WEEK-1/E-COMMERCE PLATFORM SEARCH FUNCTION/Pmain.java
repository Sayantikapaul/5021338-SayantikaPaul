import java.util.*;
class Product {
  int productId;
  String productName;
  String category;

  Product(int productId,String productName,String category)
  {
    this.productId=productId;
    this.productName=productName;
    this.category=category;
  }
}

class ProductSystem{
  public ArrayList<Product> productsList;

  ProductSystem()
  {
    productsList=new ArrayList<>();
  }

  //1. Add
  public void addProduct(int productId, String productName, String category)
  {
    productsList.add(new Product(productId, productName, category));
    System.out.println("Products are added Successfully");
  }

  //2.Search-by-ID
  public void searchById(int id)
  {
    for(int i=0;i<productsList.size();i++)
    {
      Product product=productsList.get(i);
      if(product.productId==id)
      {
        System.out.println("Found the product");
        System.out.println("ProductID: "+product.productId);
        System.out.println("Product Name: "+product.productName);
        System.out.println("Product Category: "+product.category);
        System.out.println();
        return;
      }
    }
    System.out.println("Item not found");
  }

  //3.Search-by-Category
  public void searchByCategory(String requiredCategory){
    for(int i=0;i<productsList.size();i++)
    {
      Product product=productsList.get(i);
      if(product.category.equals(requiredCategory))
      {
        System.out.println("Found the product");
        System.out.println("ProductID: "+product.productId);
        System.out.println("Product Name: "+product.productName);
        System.out.println("Product Category: "+product.category);
        System.out.println();
        return;
      }
    }
    System.out.println("Item not found");
  }

  //4.Search-by-name
  public void searchByName(String productName){
    for(int i=0;i<productsList.size();i++)
    {
      Product product=productsList.get(i);
      if(product.productName.equals(productName)){
        System.out.println("Found the product");
        System.out.println("ProductID: "+product.productId);
        System.out.println("Product Name: "+product.productName);
        System.out.println("Product Category: "+product.category);
        System.out.println();
        return;
      }
    }
    System.out.println("Item not found");
  }

  public void searchProduct()
  {
    Scanner SC=new Scanner(System.in);
    System.out.println("Search Depends on: ");
    System.out.println("1.ProductID");
    System.out.println("2.Product Name");
    System.out.println("3.Product Category");

    System.out.println("Enter the choice: ");
    int ch=SC.nextInt();

    switch(ch)
    {
      case 1:
        System.out.println("Enter the ID: ");
        int productId=SC.nextInt();
        searchById(productId);
        break;
      case 2:
        SC.nextLine();
        System.out.println("Enter the name: ");
        String productName=SC.nextLine();
        searchByName(productName);
        break;
      case 3:
        SC.nextLine();
        System.out.println("Enter the category: ");
        String category=SC.nextLine();
        searchByCategory(category);
        break;
      default:
        System.out.println("Wrong Choice");
    }
  }

  public void binarySearchById(int productId)
  {
    Collections.sort(productsList,(a,b)->a.productId-b.productId);
    int fst=0;
    int lst=productsList.size()-1;

    while(fst<=lst){
        int mid=fst+(lst-fst)/2;
        if(productsList.get(mid).productId==productId)
        {
          Product product=productsList.get(mid);
          System.out.println("Found the product");
          System.out.println("ProductID: "+product.productId);
          System.out.println("Product Name: "+product.productName);
          System.out.println("Product Category: "+product.category);
          System.out.println();
          return;
        }
        else if(productsList.get(mid).productId>productId)
          {
            lst=mid-1;
          }
        else{
          fst=mid+1;
        }
      }
      System.out.println("ITEM NOT FOUND!");
    }

    public void binarySearcgByname(String productName)
    {
      Collections.sort(productsList,(a,b)->a.productName.compareTo(b.productName));
      int fst=0;
      int lst=productsList.size()-1;

      while(fst<=lst){
          int mid=fst+(lst-fst)/2;
          if(productsList.get(mid).productName.equals(productName))
          {
            Product product=productsList.get(mid);
            System.out.println("Found the product");
            System.out.println("ProductID: "+product.productId);
            System.out.println("Product Name: "+product.productName);
            System.out.println("Product Category: "+product.category);
            System.out.println();
            return;
          }
          else if(productsList.get(mid).productName.compareTo(productName)>0)
          {
            lst=mid-1;
          }
          else{
            fst=mid+1;
          }
      }
        System.out.println("ITEM NOT FOUND!");
  }

  public void binarySearchByCategory(String category)
  {
    Collections.sort(productsList,(a,b)->a.category.compareTo(b.category));
      int fst=0;
      int lst=productsList.size()-1;

      while(fst<=lst){
          int mid=fst+(lst-fst)/2;
          if(productsList.get(mid).category.equals(category))
          {
            Product product=productsList.get(mid);
            System.out.println("Found the product");
            System.out.println("ProductID: "+product.productId);
            System.out.println("Product Name: "+product.productName);
            System.out.println("Product Category: "+product.category);
            System.out.println();
            return;
          }
          else if(productsList.get(mid).category.compareTo(category)>0)
          {
            lst=mid-1;
          }
          else{
            fst=mid+1;
          }
      }
        System.out.println("ITEM NOT FOUND!");
  }

  public void binary_search(){
        Scanner SC = new Scanner(System.in);
        System.out.println("Search Depends on : ");
        System.out.println("1. Product Id ");
        System.out.println("2. Product Name ");
        System.out.println("3. Product Category ");

        System.out.println("Enter the choice ");
        int ch = SC.nextInt();
        switch(ch){
            case 1: 
                System.out.println("Enter the Id : ");
                int productId = SC.nextInt();
                binarySearchById(productId);
                break;
            case 2: 
                SC.nextLine();
                System.out.println("Enter the Name : ");
                String productName = SC.nextLine();
                searchByName(productName);
                break;
            case 3: 
                SC.nextLine();
                System.out.println("Enter the Category : ");
                String category = SC.nextLine();
                searchByCategory(category);
                break;
            default:
             System.out.println("Wrong Choice!");
        }
  }

  public void displayProducts(){
    for(int i=0;i<productsList.size();i++)
    {
      Product product=productsList.get(i);
      System.out.println("Found the product");
      System.out.println("ProductID: "+product.productId);
      System.out.println("Product Name: "+product.productName);
      System.out.println("Product Category: "+product.category);
      System.out.println();
    }
  }

}

public class Pmain {
  public static void main(String[] args) {
    ProductSystem productSystem = new ProductSystem();
        while(true){
            Scanner SC = new Scanner(System.in);
            System.out.println("E COMMERCE PLATFORM SERACHING SYSTEM");
            System.out.println("1. Add ");
            System.out.println("2. Search");
            System.out.println("3. Binary Search");
            System.out.println("4. Print ");
            System.out.println("5. Exit");

            System.out.println("Enter choice : ");
            int ch = SC.nextInt();

            switch(ch){
                case 1:
                    System.out.println("Enter Product ID: ");
                    int productId = SC.nextInt();
                    SC.nextLine();  // Consume the newline
            
                    System.out.println("Enter Product Name: ");
                    String productName = SC.nextLine();
            
                    System.out.println("Enter Product Category: ");
                    String productCategory = SC.nextLine();
            
                    productSystem.addProduct(productId, productName, productCategory);
                    break;
                case 2:
                    productSystem.searchProduct();
                  break;
                case 3:
                    productSystem.binary_search();
                    break;  
                case 4:
                    productSystem.displayProducts();
                    break;
                case 5:
                 System.exit(0);
                default:
                 System.out.println("OOPS! WRONG CHOICE !");
            }
     }
  }      
}
