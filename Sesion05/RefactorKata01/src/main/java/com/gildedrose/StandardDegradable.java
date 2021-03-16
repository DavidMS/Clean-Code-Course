package com.gildedrose;

public class StandardDegradable implements Degradable {

    private final int increment;
    private final int sellIn;

    public StandardDegradable(int increment, int sellIn) {
        this.increment = increment;
        this.sellIn = sellIn;
    }

    @Override
    public int updateQuality() {
        if(sellIn <= 0) {
            return increment * 2;
        } else {
            return increment;
        }
    }
}
