import java.util.ArrayList;
import java.util.List;
interface Observer {
    void update(String stockName, double price);
}
interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
    public void setStock(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }
}
class MobileApp implements Observer {

    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App: " + stockName + " price is Rs." + price);
    }
}
class WebApp implements Observer {

    @Override
    public void update(String stockName, double price) {
        System.out.println("Web App: " + stockName + " price is Rs." + price);
    }
}
public class ObserverPatternExample {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();
        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);
        stockMarket.setStock("TCS", 3850.50);
        System.out.println();
        stockMarket.setStock("CTS", 6620.75);
    }
}