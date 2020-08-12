package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final int MAX_QUALITY = 50;

    private static final int MIN_QUALITY = 0;

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void lessQuality() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20)
            };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    public void lessQuality_exceptionNegative() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, MIN_QUALITY)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(9, item.sellIn);
        assertEquals(MIN_QUALITY, item.quality);
    }

    @Test
    public void lessQualitySellInExpired() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", -1, 2)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    public void isAgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 10, 10)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(9, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    public void addQuality_exceptionGreaterThan50() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 10, MAX_QUALITY)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(9, item.sellIn);
        assertEquals(MAX_QUALITY, item.quality);
    }

    @Test
    public void isSulfuras() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 10, 10)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(10, item.sellIn);
        assertEquals(10, item.quality);
    }

    @Test
    public void backstageSellInGreaterThan10() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(10, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    public void backstageSellInSmallerOrEqual10() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(9, item.sellIn);
        assertEquals(12, item.quality);
    }

    @Test
    public void backstageSellInSmallerOrEqual5() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(4, item.sellIn);
        assertEquals(13, item.quality);
    }

    @Test
    public void backstageSellInExpired() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", -2, MIN_QUALITY)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(-3, item.sellIn);
        assertEquals(MIN_QUALITY, item.quality);
    }

    @Test
    public void isConjured() {
        Item[] items = new Item[] {
                new Item("Conjured Mana Cake", 10, 10)
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item item = items[0];

        assertEquals(9, item.sellIn);
        assertEquals(8, item.quality);
    }

}
