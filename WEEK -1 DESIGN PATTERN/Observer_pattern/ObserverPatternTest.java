package Observer_pattern;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        stockMarket.setStockPrice(100.50);
        System.out.println();

        stockMarket.setStockPrice(105.75);
        System.out.println();

        stockMarket.removeObserver(mobileApp2);
        stockMarket.setStockPrice(110.00);
    }
}
