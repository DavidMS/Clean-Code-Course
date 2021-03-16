package com.gildedrose;

public class LegendaryQualityLimiter implements QualityLimiter {

    @Override
    public int adjustQuality(int currentQuality) {
        return currentQuality;
    }
}
