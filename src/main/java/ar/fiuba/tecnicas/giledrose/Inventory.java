package ar.fiuba.tecnicas.giledrose;

import ar.fiuba.tecnicas.giledrose.utils.Range;

public class Inventory {
	private Item[] items;

	public Inventory(Item[] items) {
		super();
		this.items = items;
	}

	public Inventory() {
		super();
		items =
				new Item[] {
						new Item("+5 Dexterity Vest", 10, 20),
						new Item("Aged Brie", 2, 0),
						new Item("Elixir of the Mongoose", 5, 7),
						new Item("Sulfuras, Hand of Ragnaros", 0, 80),
						new Item("Backstage passes to a TAFKAL80ETC concert",
								15, 20), new Item("Conjured Mana Cake", 3, 6) };
	}

	public void updateQuality() {
		ItemUpdate itemToUpdate = new ItemUpdate();
		for (int i = 0; i < items.length; i++) {
			itemToUpdate.setItem(items[i]);
			itemToUpdate.update();
		}
	}

	private class ItemUpdate {
		private static final String NAME_BRIE = "Aged Brie";
		private static final String NAME_SULFURAS =
				"Sulfuras, Hand of Ragnaros";
		private static final String NAME_BACKSTAGE =
				"Backstage passes to a TAFKAL80ETC concert";
		private static final String NAME_CAKE = "Conjured Mana Cake";

		private static final int MIN_QUALITY = 0;
		private static final int MAX_QUALITY = 50;

		private Range<Integer> rangeOfAllowedQuality = new Range<Integer>(
				MIN_QUALITY, MAX_QUALITY);
		private Item item;

		public void setItem(Item item) {
			this.item = item;
		}

		public void update() {
			if (isAgedBrie()) {
				updateAgedBrie();
				return;
			}
			if (isConcertPasses()) {
				updateConcertPasses();
				return;
			}
			if (isConjuredCake()) {
				updateConjuredCake();
				return;
			}
			if (!isSulfuras()) {
				updateOrdinaryItem();
			}
		}

		private void updateAgedBrie() {
			incrementQualityByOne();
			decrementSellInByOne();
			if (isExpired()) {
				incrementQualityByOne();
			}
		}

		private void updateConcertPasses() {
			incrementQualityByOne();
			if (isSellInLessThanEleven()) {
				incrementQualityByOne();
			}
			if (isSellInLessThanSix()) {
				incrementQualityByOne();
			}
			decrementSellInByOne();
			if (isExpired()) {
				setQualityToZero();
			}
		}

		private void updateConjuredCake() {
			decrementQualityByTwo();
			decrementSellInByOne();
			if (isExpired()) {
				decrementQualityByTwo();
			}
		}

		private void updateOrdinaryItem() {
			decrementQualityByOne();
			decrementSellInByOne();
			if (isExpired()) {
				decrementQualityByOne();
			}
		}

		private boolean isAgedBrie() {
			return item.getName() == NAME_BRIE;
		}

		private boolean isSulfuras() {
			return item.getName() == NAME_SULFURAS;
		}

		private boolean isConcertPasses() {
			return item.getName() == NAME_BACKSTAGE;
		}

		private boolean isConjuredCake() {
			return item.getName() == NAME_CAKE;
		}

		private boolean isExpired() {
			return item.getSellIn() < 0;
		}

		private boolean isSellInLessThanSix() {
			return item.getSellIn() < 6;
		}

		private boolean isSellInLessThanEleven() {
			return item.getSellIn() < 11;
		}

		private void incrementQuality(int incrementInQuality) {
			item.setQuality(item.getQuality() + incrementInQuality);
			if (rangeOfAllowedQuality.notIncludes(item.getQuality())) {
				item.setQuality(MAX_QUALITY);
			}
		}

		private void decrementQuality(int decrementInQuality) {
			item.setQuality(item.getQuality() - decrementInQuality);
			if (rangeOfAllowedQuality.notIncludes(item.getQuality())) {
				item.setQuality(MIN_QUALITY);
			}
		}

		private void incrementQualityByOne() {
			incrementQuality(1);
		}

		private void decrementQualityByOne() {
			decrementQuality(1);
		}

		private void decrementQualityByTwo() {
			decrementQuality(2);
		}

		private void setQualityToZero() {
			item.setQuality(0);
		}

		private void decrementSellInByOne() {
			item.setSellIn(item.getSellIn() - 1);
		}
	}
}