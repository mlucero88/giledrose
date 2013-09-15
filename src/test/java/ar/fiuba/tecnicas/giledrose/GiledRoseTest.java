package ar.fiuba.tecnicas.giledrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/* Tests del metodo updateQuality para diferentes escenarios e items */
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

	/* Método para inicializar un Inventory con un solo Item y actualizar su
	 * quality */
	public void updateQualityOneItem(String nameItem, int sellInItem,
			int qualityItem) {
		testedItem = new Item(nameItem, sellInItem, qualityItem);
		testedInventory = new Inventory(new Item[] { testedItem });
		testedInventory.updateQuality();
	}

	/* Tests VEST */
	@Test
	public void testVestQualityGreaterThanOneAndSellInEqualsZero() {
		/* 1 < quality */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 10;
		updateQualityOneItem(NAME_VEST, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 2, testedItem.getQuality());
	}

	@Test
	public void testVestQualityEqualsOneAndSellInEqualsZero() {
		/* quality = 1 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 1;
		updateQualityOneItem(NAME_VEST, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testVestQualityEqualsZeroAndSellInEqualsZero() {
		/* quality = 0 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 0;
		updateQualityOneItem(NAME_VEST, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testVestQualityAndSellInGreaterThanZero() {
		/* 0 < quality */
		/* 0 < sellIn */
		final int sellIn = 2;
		final int quality = 2;
		updateQualityOneItem(NAME_VEST, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	/* Tests BRIE */
	@Test
	public void testBrieQualityLessThan49AndSellInEqualsZero() {
		/* quality < 49 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 48;
		updateQualityOneItem(NAME_BRIE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 2, testedItem.getQuality());
	}

	@Test
	public void testBrieQualityEquals49AndSellInEqualsZero() {
		/* quality = 49 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 49;
		updateQualityOneItem(NAME_BRIE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	@Test
	public void testBrieQualityEquals50AndSellInEqualsZero() {
		/* quality = 50 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 50;
		updateQualityOneItem(NAME_BRIE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testBrieQualityLessThan49AndSellInGreaterThanZero() {
		/* quality < 49 */
		/* 0 < sellIn */
		final int sellIn = 3;
		final int quality = 10;
		updateQualityOneItem(NAME_BRIE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	/* Tests ELIXIR */
	@Test
	public void testElixirQualityGreaterThanOneAndSellInEqualsZero() {
		/* 1 < quality */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 10;
		updateQualityOneItem(NAME_ELIXIR, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 2, testedItem.getQuality());
	}

	@Test
	public void testElixirQualityEqualsOneAndSellInEqualsZero() {
		/* quality = 1 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 1;
		updateQualityOneItem(NAME_ELIXIR, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testElixirQualityEqualsZeroAndSellInEqualsZero() {
		/* quality = 0 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 0;
		updateQualityOneItem(NAME_ELIXIR, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testElixirQualityAndSellInGreaterThanZero() {
		/* 0 < quality */
		/* 0 < sellIn */
		final int sellIn = 2;
		final int quality = 2;
		updateQualityOneItem(NAME_ELIXIR, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	/* Tests SULFURAS */
	@Test
	public void testSulfurasQualityEquals80SellinEqualsZero() {
		/* quality = 80 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 80;
		updateQualityOneItem(NAME_SULFURAS, sellIn, quality);
		assertEquals(sellIn, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	/* Tests BACKSTAGE */
	@Test
	public void testBackstageSellInEqualsZero() {
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 47;
		updateQualityOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(0, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityEquals50AndSellInNotZero() {
		/* quality = 50 */
		/* sellIn != 0 */
		final int sellIn = 12;
		final int quality = 50;
		updateQualityOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityLessThan48AndSellInBetweenOneAndFive() {
		/* quality < 48 */
		/* 1 <= sellIn <= 5 */
		final int sellIn = 1;
		final int quality = 47;
		updateQualityOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 3, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityEquals48AndSellInBetweenOneAndFive() {
		/* quality = 48 */
		/* 1 <= sellIn <= 5 */
		final int sellIn = 5;
		final int quality = 48;
		updateQualityOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 2, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityEquals49AndSellInBetweenOneAndFive() {
		/* quality = 49 */
		/* 1 <= sellIn <= 5 */
		final int sellIn = 5;
		final int quality = 49;
		updateQualityOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityLessThan48AndSellInBetweenSixAndTen() {
		/* quality < 48 */
		/* 6 <= sellIn <= 10 */
		final int sellIn = 6;
		final int quality = 47;
		updateQualityOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 2, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityEquals49AndSellInBetweenSixAndTen() {
		/* quality = 49 */
		/* 6 <= sellIn <= 10 */
		final int sellIn = 10;
		final int quality = 49;
		updateQualityOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	@Test
	public void testBackstageQualityLessThan50AndSellInGreaterThanTen() {
		/* quality < 50 */
		/* 10 < sellIn */
		final int sellIn = 11;
		final int quality = 49;
		updateQualityOneItem(NAME_BACKSTAGE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality + 1, testedItem.getQuality());
	}

	/* Tests CAKE */
	@Test
	public void testCakeQualityGreaterThanThreeAndSellInEqualsZero() {
		/* 3 < quality */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 4;
		updateQualityOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 4, testedItem.getQuality());
	}

	public void testCakeQualityEqualsThreeAndSellInEqualsZero() {
		/* quality = 3 */
		/* sellIn = 0 */
		final int sellIn = 0;
		final int quality = 3;
		updateQualityOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 3, testedItem.getQuality());
	}

	public void testCakeQualityEqualsTwo() {
		/* quality = 2 */
		final int sellIn = 0;
		final int quality = 2;
		updateQualityOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 2, testedItem.getQuality());
	}

	@Test
	public void testCakeQualityEqualsOne() {
		/* quality = 1 */
		final int sellIn = 0;
		final int quality = 1;
		updateQualityOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 1, testedItem.getQuality());
	}

	@Test
	public void testCakeQualityEqualsZero() {
		/* quality = 0 */
		final int sellIn = 0;
		final int quality = 0;
		updateQualityOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality, testedItem.getQuality());
	}

	@Test
	public void testCakeQualityGreaterThanOneAndSellInGreaterThanZero() {
		/* 1 < quality */
		/* 0 < sellIn */
		final int sellIn = 1;
		final int quality = 2;
		updateQualityOneItem(NAME_CAKE, sellIn, quality);
		assertEquals(sellIn - 1, testedItem.getSellIn());
		assertEquals(quality - 2, testedItem.getQuality());
	}
}