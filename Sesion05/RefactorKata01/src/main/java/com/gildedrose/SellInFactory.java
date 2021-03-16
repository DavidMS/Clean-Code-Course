package com.gildedrose;

public class SellInFactory {

    public static SellInCalculator createQualityLimiter(Item item) {
        if("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new LegendarySellInCalculator();
        } else {
            return new StandardSellInCalculator();
        }
    }
}
