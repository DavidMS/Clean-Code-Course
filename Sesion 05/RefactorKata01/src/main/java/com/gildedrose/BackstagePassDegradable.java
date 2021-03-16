package com.gildedrose;

public class BackstagePassDegradable implements Degradable {

    private final int sellIn;
    private final int quality;

    public BackstagePassDegradable(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }


    @Override
    public int updateQuality() {
        if(sellIn <= 10) {
            return 2;
        } else if (sellIn <= 5) {
            return 3;
        } else if (sellIn <= 0) {
            return -quality;
        } else {
            return 1;
        }
    }
}
