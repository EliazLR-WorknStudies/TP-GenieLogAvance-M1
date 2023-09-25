package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            //Traitement avant mis-à-jour du sellIn
            beforeSellInUpdate(i);

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn -= 1;
            }

            //Traitement après mis-à-jour du sellIn
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality -= 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality += 1;
                    }
                }
            }
        }
    }

    private void beforeSellInUpdate(int i){
        //Traitement avant mis-à-jour du sellIn
        if (!items[i].name.equals("Aged Brie")
            && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].quality > 0) {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].quality -= 1;
                        
                }
            }
        } else {
            if (items[i].quality < 50) {
                
                items[i].quality += 1;

                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].sellIn < 11 && items[i].quality < 50) {
                            
                        items[i].quality += 1;
                    }

                    if (items[i].sellIn < 6 && items[i].quality < 50) {
                            
                        items[i].quality += 1;
                    }
                }
            }
        }
    } 

}