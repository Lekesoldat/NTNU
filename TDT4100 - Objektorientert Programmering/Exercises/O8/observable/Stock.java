import java.util.ArrayList;
import java.util.List;

  public class Stock {
  private String ticker; 
  private double price;
  private List<StockListener> listeners = new ArrayList<>();

  public Stock(String ticker, double price) {
    this.ticker = ticker;
    this.price = price;
  }

  public void setPrice(double newPrice) {
    if (newPrice <= 0) {
      throw new IllegalArgumentException("Invalid price");
    }

    if (this.price != newPrice) {
      double oldPrice = this.price;
      this.price = newPrice;
      fireStockPriceChanged(oldPrice);
    }
  }

  public String getTicker() {
    return this.ticker;
  }

  public double getPrice() {
    return this.price;
  }

  public void addStockListener(StockListener listener) {
    listeners.add(listener);
  }

  public void removeStockListener(StockListener listener) {
    listeners.remove(listener);
  }

  public void fireStockPriceChanged(double oldPrice) {
    for (StockListener listener : listeners) {
      listener.stockPriceChanged(this, oldPrice, this.price);
    }
  }

  @Override
  public String toString() {
    return 
      new StringBuilder()
      .append("Ticker: " + this.ticker + "\n")
      .append("Price: " + this.price + "\n")
      .toString();
  }
}