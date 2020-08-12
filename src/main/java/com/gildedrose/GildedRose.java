package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            switch (item.name) {
                case "Aged Brie":
                    isAgedBrie(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    isBackstagePasses(item);
                    break;
                case "Conjured Mana Cake":
                    isConjured(item);
                    break;
                default:
                    isOtherItems(item);
                    break;
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) item.sellIn--;

        }
    }

    /**
     * Use if item is Aged Brie
     * @param item {@link Item}
     */
    private void isAgedBrie(Item item) {
        addQuality(item);
    }

    /**
     * Use if item is Backstage Passes
     * @param item {@link Item}
     */
    private void isBackstagePasses(Item item) {
        if (item.sellIn < 0) { // date expired
            item.quality = 0;
        } else if (item.sellIn <= 5) { // date between 0 and 5
            addQuality(item);
            addQuality(item);
            addQuality(item);
        } else if (item.sellIn <= 10) { // date between 5 and 10
            addQuality(item);
            addQuality(item);
        } else { // date greater than 10
            addQuality(item);
        }
    }

    /**
     * Use if item is Conjured
     * @param item {@link Item}
     */
    private void isConjured(Item item) {
        isOtherItems(item);
        isOtherItems(item);
    }

    /**
     * Use if other items
     * @param item {@link Item}
     */
    private void isOtherItems(Item item) {
        if (item.sellIn < 0) {
            lessQuality(item);
            lessQuality(item);
        } else {
            lessQuality(item);
        }
    }

    private void addQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        } else {
            // create class error
            System.out.println("the quality can not be above 50");
        }
    }

    private void lessQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        } else {
            // create class error
            System.out.println("the quality cannot be negative");
        }
    }
}
