package com.example.GildedRose;

class GildedRose {
    Item[] items;

    private static final Integer ITEM_QUALITY_50 = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality--;
                }

            } else if (item.quality < ITEM_QUALITY_50) {
                item.quality++;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sellIn < 11) {
                        if (item.quality < ITEM_QUALITY_50) {
                            item.quality++;
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else if (item.quality < ITEM_QUALITY_50) {
                    item.quality++;
                }
            }
        }
    }
}