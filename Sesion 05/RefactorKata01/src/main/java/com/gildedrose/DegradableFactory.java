package com.gildedrose;

public class DegradableFactory {

    public static Degradable createDegradable(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new StandardDegradable(1, item.sellIn);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassDegradable(item.sellIn, item.quality);
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryDegradable();
            default:
                return new StandardDegradable(-1, item.sellIn);
        }
    }
}
