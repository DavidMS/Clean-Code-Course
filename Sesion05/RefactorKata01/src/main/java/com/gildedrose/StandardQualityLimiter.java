package com.gildedrose;

public class StandardQualityLimiter implements QualityLimiter {
    @Override
    public int adjustQuality(int currentQuality) {
        if(currentQuality > 50) {
            return 50;
        } else if(currentQuality < 0) {
            return 0;
        } else {
            return currentQuality;
        }
    }
}
