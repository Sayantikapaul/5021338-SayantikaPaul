public class Main {
    
  public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
      // Base case: If no more periods, return the present value
      if (periods == 0) {
          return presentValue;
      }
      // Recursive case: Calculate future value for remaining periods
      return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
  }

  public static double calculateFutureValue_by_iteation(double presentValue, double growthRate, int periods){
      // 1st APPROACH 
      // double futureValue = presentValue * Math.pow((1 + growthRate) ,periods); 

      /*
       *  FOURMULA, A = P * (1 + R)^n; 
       */

      double futureValue= presentValue;
      for(int i = 0; i < periods; i++){
          futureValue = futureValue * (1 + growthRate);
      }
      return futureValue;
  }

  public static void main(String[] args) {
      double presentValue = 1000; // Initial value
      double growthRate = 0.05;   // 5% growth rate
      int periods = 10;           // Number of periods

      System.out.println("BY RECURSION PROCESS");
      double futureValue = calculateFutureValue(presentValue, growthRate, periods);
      System.out.println("The future value is: " + futureValue);

      System.out.println("BY ITERATION PROCESS");
      double futureValue2 = calculateFutureValue_by_iteation(presentValue, growthRate, periods);
      System.out.println("The future value is: " + futureValue2);
  }
}
