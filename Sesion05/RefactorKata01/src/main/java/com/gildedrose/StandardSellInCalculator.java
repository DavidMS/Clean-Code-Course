package com.gildedrose;

public class StandardSellInCalculator implements SellInCalculator{
    @Override
    public int calculateSellIn(int sellIn) {
        return sellIn -1;
    }
}
