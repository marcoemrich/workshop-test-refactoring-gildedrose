package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseTest {

	@Test
	public void ShouldUpdateQualityAndSellInCorrectlyWhileNotChangingNames() {
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 0, 0),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Sulfuras, Hand of Ragnaros", 0, 0),
				new Item("Sulfuras, Hand of Ragnaros", -1, 100),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 49)
		};

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals("+5 Dexterity Vest", app.items[0].name);
		assertEquals(9, app.items[0].sellIn);
		assertEquals(19, app.items[0].quality);

		assertEquals("Aged Brie", app.items[1].name);
		assertEquals(2, app.items[1].quality);
		assertEquals(-1, app.items[1].sellIn);

		assertEquals("Elixir of the Mongoose", app.items[2].name);
		assertEquals(4, app.items[2].sellIn);
		assertEquals(6, app.items[2].quality);

		assertEquals("Sulfuras, Hand of Ragnaros", app.items[3].name);
		assertEquals(0, app.items[3].quality);
		assertEquals(0, app.items[3].sellIn);

		assertEquals("Sulfuras, Hand of Ragnaros", app.items[4].name);
		assertEquals(100, app.items[4].quality);
		assertEquals(-1, app.items[4].sellIn);

		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[5].name);
		assertEquals(21, app.items[5].quality);
		assertEquals(14, app.items[5].sellIn);

		app.items[1].quality = 100;

		app.updateQuality();

		assertEquals(8, app.items[0].sellIn);
		assertEquals(18, app.items[0].quality);

		assertEquals(100, app.items[1].quality);
		assertEquals(-2, app.items[1].sellIn);

		assertEquals(3, app.items[2].sellIn);
		assertEquals(5, app.items[2].quality);

		assertEquals(0, app.items[3].quality);
		assertEquals(0, app.items[3].sellIn);

		assertEquals(100, app.items[4].quality);
		assertEquals(-1, app.items[4].sellIn);

		assertEquals(22, app.items[5].quality);
		assertEquals(13, app.items[5].sellIn);

		for (int i = 1; i <= 4; ++i) { app.updateQuality(); }

		assertEquals(27, app.items[5].quality);
		assertEquals(9, app.items[5].sellIn);

		assertEquals(50, app.items[6].quality);
		assertEquals(9, app.items[6].sellIn);

		for (int i = 1; i <= 5; ++i) { app.updateQuality(); }

		assertEquals(38, app.items[5].quality);
		assertEquals(4, app.items[5].sellIn);

		assertEquals(50, app.items[6].quality);
		assertEquals(4, app.items[6].sellIn);

		for (int i = 1; i <= 4; ++i)  { app.updateQuality(); }

		assertEquals(50, app.items[5].quality);
		assertEquals(0, app.items[5].sellIn);

		assertEquals(50, app.items[6].quality);
		assertEquals(0, app.items[6].sellIn);

		app.updateQuality();

		assertEquals(0, app.items[5].quality);
		assertEquals(-1, app.items[5].sellIn);

		assertEquals(0, app.items[6].quality);
		assertEquals(-1, app.items[6].sellIn);
	}
}
