package google2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BestTimeToBuyAndSellTheStock {
  public int maxProfit(int[] prices) {
    int currenProfit = 0;
    if (prices.length == 0) {
      return currenProfit;
    }
    int lastPricePurchased = prices[0];
    for (int price: prices) {
      if (price <= lastPricePurchased) {
        lastPricePurchased = price;
      }
      currenProfit+=(price - lastPricePurchased);
      lastPricePurchased = price;
    }
    return currenProfit;
  }

  @Test
  public void run() {
    int[] in = {7,1,5,3,6,4};
    log.info(maxProfit(in) + "");

  }
}
