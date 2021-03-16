package com.gildedrose;

public class QualityLimiterFactory {

    public static QualityLimiter createQualityLimiter(Item item) {
        if("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new LegendaryQualityLimiter();
        } else {
            return new StandardQualityLimiter();
        }
    }
}
