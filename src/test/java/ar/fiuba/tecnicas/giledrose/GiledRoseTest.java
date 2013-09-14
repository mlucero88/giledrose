package ar.fiuba.tecnicas.giledrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GiledRoseTest {
	private static final String NAME_VEST = "+5 Dexterity Vest";
	private static final String NAME_BRIE = "Aged Brie";
	private static final String NAME_ELIXIR = "Elixir of the Mongoose";
	private static final String NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String NAME_BACKSTAGE =
			"Backstage passes to a TAFKAL80ETC concert";
	private static final String NAME_CAKE = "Conjured Mana Cake";

	private static Item testedItem;
	private static Inventory testedInventory;

	/* Tests del metodo updateQuality para diferentes escenarios e items */
	public void setUpOneItem(String nameItem, int sellInItem, int qualityItem) {
		testedItem = new Item(nameItem, sellInItem, qualityItem);
		testedInventory = new Inventory(new Item[] { testedItem });
		testedInventory.updateQuality();
	}

	/* Tests VEST */
	@Test
	public void testVestQualityGreaterThanOneSellInEqualsZero() {
		/* 1 < quality */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 2;
		setUpOneItem(NAME_VEST, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 2, testedItem.getQuality());
	}

	@Test
	public void testVestQualityAndSellInGreaterThanOne() {
		/* 1 < quality */
		/* 1 < sellIn */
		final int sellIn = 2;
		final int quality = 2;
		setUpOneItem(NAME_VEST, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testVestQualityEqualsOneAndSellInGreaterThanOne() {
		/* quality = 1 */
		/* 1 < sellIn */
		final int sellIn = 3;
		final int quality = 1;
		setUpOneItem(NAME_VEST, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testVestQualityEqualsZeroAndSellInNegative() {
		/* quality = 0 */
		/* sellIn < 0 */
		final int sellIn = -1;
		final int quality = 0;
		setUpOneItem(NAME_VEST, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	/* Tests BRIE */
	@Test
	public void testBrieQualityLessThan49AndSellInEqualsZero() {
		/* quality < 49 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 48;
		setUpOneItem(NAME_BRIE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 2, testedItem.getQuality());
	}

	@Test
	public void testBrieQualityLessThan49AndPositiveSellIn() {
		/* quality < 49 */
		/* 0 < sellIn */
		final int sellIn = 1;
		final int quality = 1;
		setUpOneItem(NAME_BRIE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	@Test
	public void testBrieQualityEquals50() {
		/* quality = 50 */
		final int sellIn = -2;
		final int quality = 50;
		setUpOneItem(NAME_BRIE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testBrieQualityEquals49() {
		/* quality = 49 */
		final int sellIn = -10;
		final int quality = 49;
		setUpOneItem(NAME_BRIE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	/* Tests ELIXIR */
	@Test
	public void testElixirQualityGreaterThanOneSellInEqualsZero() {
		/* 1 < quality */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 2;
		setUpOneItem(NAME_ELIXIR, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 2, testedItem.getQuality());
	}

	@Test
	public void testElixirQualityAndSellInGreaterThanOne() {
		/* 1 < quality */
		/* 1 < sellIn */
		final int sellIn = 2;
		final int quality = 2;
		setUpOneItem(NAME_ELIXIR, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testElixirQualityEqualsOneAndSellInGreaterThanOne() {
		/* quality = 1 */
		/* 1 < sellIn */
		final int sellIn = 3;
		final int quality = 1;
		setUpOneItem(NAME_ELIXIR, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testElixirQualityEqualsZeroAndSellInNegative() {
		/* quality = 0 */
		/* sellIn < 0 */
		final int sellIn = -1;
		final int quality = 0;
		setUpOneItem(NAME_ELIXIR, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	/* Tests SULFURAS */
	@Test
	public void testSulfurasPositiveQualityPositiveSellin() {
		/* 0 < quality */
		/* 0 < sellIn */
		final int sellIn = 1;
		final int quality = 50;
		setUpOneItem(NAME_SULFURAS, sellIn, quality);
		assertEquals(sellIn, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testSulfurasPositiveQualityNegativeSellin() {
		/* 0 < quality */
		/* sellIn < 0 */
		final int sellIn = -1;
		final int quality = 10;
		setUpOneItem(NAME_SULFURAS, sellIn, quality);
		assertEquals(sellIn, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testSulfurasNegativeQualityPositiveSellin() {
		/* quality < 0 */
		/* 0 < sellIn */
		final int sellIn = 5;
		final int quality = -1;
		setUpOneItem(NAME_SULFURAS, sellIn, quality);
		assertEquals(sellIn, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testSulfurasQualityAndSellinEqualsZero() {
		/* quality = 0 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 0;
		setUpOneItem(NAME_SULFURAS, sellIn, quality);
		assertEquals(sellIn, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	/* Tests BACKSTAGE */
	@Test
	public void testBackstageQualityLessThan48AndSellInEqualsZero() {
		/* quality < 48 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 47;
		setUpOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - quality, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityLessThan48AndSellInBetweenZeroAndSix() {
		/* quality < 48 */
		/* 0 < sellIn < 6 */
		final int sellIn = 1;
		final int quality = 47;
		setUpOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 3, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityEquals48AndSellInBetweenZeroAndSix() {
		/* quality = 48 */
		/* 0 < sellIn < 6 */
		final int sellIn = 5;
		final int quality = 48;
		setUpOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 2, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityLessThan48AndSellInBetweenFiveAndEleven() {
		/* quality < 48 */
		/* 5 < sellIn < 11 */
		final int sellIn = 6;
		final int quality = 47;
		setUpOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 2, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityEquals49AndSellInBetweenFiveAndEleven() {
		/* quality = 49 */
		/* 5 < sellIn < 11 */
		final int sellIn = 10;
		final int quality = 49;
		setUpOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityLessThan49AndSellInGreaterThanTen() {
		/* quality < 49 */
		/* 10 < sellIn */
		final int sellIn = 11;
		final int quality = 48;
		setUpOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityGreaterThan49AndSellInGreaterThanZero() {
		/* 49 < quality */
		/* 0 < sellIn */
		final int sellIn = 1;
		final int quality = 50;
		setUpOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityGreaterThan49AndSellInLessThanOne() {
		/* 49 < quality */
		/* sellIn < 1 */
		final int sellIn = 0;
		final int quality = 50;
		setUpOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - quality, testedItem.getQuality());
	}

	/* Tests CAKE */
	@Test
	public void testCakeQualityGreaterThanOneSellInEqualsZero() {
		final int sellIn = 0;
		final int quality = 2;
		setUpOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 2, testedItem.getQuality());
	}

	@Test
	public void testCakeQualityAndSellInGreaterThanOne() {
		final int sellIn = 2;
		final int quality = 2;
		setUpOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testCakeQualityEqualsOneAndSellInGreaterThanOne() {
		final int sellIn = 3;
		final int quality = 1;
		setUpOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testCakeQualityEqualsZeroAndSellInNegative() {
		final int sellIn = -1;
		final int quality = -1;
		setUpOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}
}