package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.interfaces.NonLegendaryItem;

public class AgedBrie extends Item implements NonLegendaryItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateSellIn() {
        sellIn--;
    }

    @Override
    public void updateQuality() {
        if (sellIn > 0) quality = updateDefault();
        if (sellIn <= 0 ) quality = updateExpired();
    }

    public int updateDefault() {
        return Math.min(++quality,50);
    }

    public int updateExpired() {
        return Math.min(quality+2,50);
    }
}
