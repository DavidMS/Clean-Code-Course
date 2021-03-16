package com.gildedrose;

import java.util.stream.Stream;

public class GildedRoseFixed {

    private Item[] items;

    public GildedRoseFixed(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Stream.of(items).forEach(this::updateQuality);
    }
    
    private void updateQuality(Item item) {

        Degradable degradableItem = DegradableFactory.createDegradable(item);
        QualityLimiter qualityLimiter = QualityLimiterFactory.createQualityLimiter(item);
        SellInCalculator sellInCalculator = SellInFactory.createQualityLimiter(item);
        item.quality += degradableItem.updateQuality();
        item.quality = qualityLimiter.adjustQuality(item.quality);
        item.sellIn = sellInCalculator.calculateSellIn(item.sellIn);
    }
}
