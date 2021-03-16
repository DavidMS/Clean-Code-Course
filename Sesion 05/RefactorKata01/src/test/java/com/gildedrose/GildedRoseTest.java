package com.gildedrose;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GildedRoseTest {


    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

}
