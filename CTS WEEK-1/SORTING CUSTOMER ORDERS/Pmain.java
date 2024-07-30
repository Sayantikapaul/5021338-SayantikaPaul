import java.util.*;
class OrderDetails {
  public int orderID;
  public String customerName;
  public int totalPrice;

  OrderDetails(int orderID, String customerName, int totalPrice)
  {
    this.orderID=orderID;
    this.customerName=customerName;
    this.totalPrice=totalPrice;
  }
}

class OrderSystem {
  public ArrayList<OrderDetails> orderLists;

  OrderSystem()
  {
    orderLists=new ArrayList<>();
  }


  public void addOrder(int orderID, String customerName, int totalPrice)
  {
    orderLists.add(new OrderDetails(orderID,customerName,totalPrice));
    System.out.println("ORDER ADDED SUCCESSFULLY");
  }

  public void bubbleSortByTotalprice(){
    int n=orderLists.size();
    for (int i=0;i<n;i++) {
      for(int j=0;j<n-1-i;j++)
      {
        if(orderLists.get(j).totalPrice>orderLists.get(j+1).totalPrice){
          OrderDetails temp=orderLists.get(j);
          orderLists.set(j,orderLists.get(j+1));
          orderLists.set(j+1,temp);
        }
      }   
    }
    System.out.println("ORDERS SORTED BY TOTAl PRICE USING BUBBLE SORT");
  }

  public void quickSortByTotalPrice() {
    quickSort(0, orderLists.size() - 1);
    System.out.println("ORDERS SORTED BY TOTAL PRICE USING QUICK SORT");
    displayProducts();
}


  public void quickSort(int low,int high){
    if(low<high){
      int partitionIndex=partition(low,high);
      quickSort(low,partitionIndex-1);
      quickSort(partitionIndex+1,high);
    }
  }

  private int partition(int low,int high){
    int pivot=orderLists.get(low).totalPrice;
    int i=low+1;
    int j=high;

    while(i<=j){
      while(i<=high && orderLists.get(i).totalPrice<=pivot){
        i++;
      }

      while(j>=low && orderLists.get(j).totalPrice>pivot){
        j--;
      }

      if(i<j){
        Collections.swap(orderLists,i,j);
      }
    }
    Collections.swap(orderLists,low,j);
    return j;
  }

  public void displayProducts(){
    for(int i=0;i<orderLists.size();i++)
    {
      OrderDetails order=orderLists.get(i);
      System.out.println("OrderID: "+order.orderID);
      System.out.println("Customer Name: "+order.customerName);
      System.out.println("Order Total Price: "+order.totalPrice);
      System.out.println();
    }
  }

}


public class Pmain {
  public static void main(String args[])
  {
    OrderSystem obSystem=new OrderSystem();
    while(true){
      Scanner sc = new Scanner(System.in);
      System.out.println("Sorting Customers orders");
      System.out.println("1. Add ");
      System.out.println("2. Bubble Sort");
      System.out.println("3. Quick Sort");
      System.out.println("4. Print");
      System.out.println("5. Exit");

      System.out.println("Enter choice : ");
      int ch = sc.nextInt();

      switch(ch){
          case 1:
              System.out.println("Enter Order ID: ");
              int orderId = sc.nextInt();
              sc.nextLine();  // Consume the newline
      
              System.out.println("Enter Customer Name: ");
              String customerName = sc.nextLine();
      
              System.out.println("Enter Order total Price: ");
              int totalPrice = sc.nextInt();
      
              obSystem.addOrder(orderId, customerName, totalPrice);
              break;
          case 2:
              obSystem.bubbleSortByTotalprice();
            break;
          case 3:
              obSystem.quickSortByTotalPrice();
              break;  
          case 4:
              obSystem.displayProducts();
              break;
          case 5:
           System.exit(0);
          default:
           System.out.println("OOPS! WRONG CHOICE !");
      }
    }
  }
}
