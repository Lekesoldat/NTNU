import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StockIndex implements StockListener {
  private String name;
  private double index = 0;
  private List<Stock> stocks = new ArrayList<>();

  public StockIndex(String name, Stock... stocks) {
    this.name = name;

    for (Stock stock : stocks) {
      stock.addStockListener(this);
      addStock(stock);
    }
  }

  private void updateIndex() {
    this.index = stocks.stream().mapToDouble(Stock::getPrice).sum();
  }

  public void addStock(Stock stock) {
    if (!stocks.contains(stock)) {
      stocks.add(stock);
      this.updateIndex();
    }
  }

  public void removeStock(Stock stock) {
    if (stocks.remove(stock)) {
      this.updateIndex();
    };
  }

  public double getIndex() {
    return this.index;
  }

  public String getName() {
    return this.name;
  }

	@Override
	public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
    // this.index += newValue - oldValue;
    this.updateIndex();
  }

  @Override
  public String toString() {
    return 
      new StringBuilder()
      .append("Oslo Bors index: " + this.index + "\n")
      .append(stocks.stream().map(Stock::toString).collect(Collectors.joining("\n")))
      .toString();
  }
}

