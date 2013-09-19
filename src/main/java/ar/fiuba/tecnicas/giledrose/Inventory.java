package ar.fiuba.tecnicas.giledrose;

public class Inventory {
	/* TODO: ver si puedo acomodar estas definiciones en otro lugar más
	 * apropiado */
	private static final String NAME_BRIE = "Aged Brie";
	private static final String NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String NAME_BACKSTAGE =
			"Backstage passes to a TAFKAL80ETC concert";

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
		for (int i = 0; i < items.length; i++) {
			Item itemToUpdate = items[i];
			if (!isItemAgedBrie(itemToUpdate)
					&& !isItemConcertPasses(itemToUpdate)) {
				if (isItemQualityGreaterThanZero(itemToUpdate)) {
					if (!isItemSulfuras(itemToUpdate)) {
						decrementItemQualityByOne(itemToUpdate);
					}
				}
			}
			else {
				if (isItemQualityLessThanFifty(itemToUpdate)) {
					incrementItemQualityByOne(itemToUpdate);

					if (isItemConcertPasses(itemToUpdate)) {
						if (isItemSellInLessThanEleven(itemToUpdate)) {
							if (isItemQualityLessThanFifty(itemToUpdate)) {
								incrementItemQualityByOne(itemToUpdate);
							}
						}

						if (isItemSellInLessThanSix(itemToUpdate)) {
							if (isItemQualityLessThanFifty(itemToUpdate)) {
								incrementItemQualityByOne(itemToUpdate);
							}
						}
					}
				}
			}

			if (!isItemSulfuras(itemToUpdate)) {
				decrementItemSellInByOne(itemToUpdate);
			}

			if (isItemSellInLessThanZero(itemToUpdate)) {
				if (!isItemAgedBrie(itemToUpdate)) {
					if (!isItemConcertPasses(itemToUpdate)) {
						if (isItemQualityGreaterThanZero(itemToUpdate)) {
							if (!isItemSulfuras(itemToUpdate)) {
								decrementItemQualityByOne(itemToUpdate);
							}
						}
					}
					else {
						setItemQualityToZero(itemToUpdate);
					}
				}
				else {
					if (isItemQualityLessThanFifty(itemToUpdate)) {
						incrementItemQualityByOne(itemToUpdate);
					}
				}
			}
		}
	}

	/* TODO: ver si puedo meter estos métodos en una clase */
	private boolean isItemAgedBrie(Item item) {
		return item.getName() == NAME_BRIE;
	}

	private boolean isItemSulfuras(Item item) {
		return item.getName() == NAME_SULFURAS;
	}

	private boolean isItemConcertPasses(Item item) {
		return item.getName() == NAME_BACKSTAGE;
	}

	private boolean isItemQualityGreaterThanZero(Item item) {
		return item.getQuality() > 0;
	}

	private boolean isItemQualityLessThanFifty(Item item) {
		return item.getQuality() < 50;
	}

	private boolean isItemSellInLessThanZero(Item item) {
		return item.getSellIn() < 0;
	}

	private boolean isItemSellInLessThanSix(Item item) {
		return item.getSellIn() < 6;
	}

	private boolean isItemSellInLessThanEleven(Item item) {
		return item.getSellIn() < 11;
	}

	private void incrementItemQualityByOne(Item item) {
		item.setQuality(item.getQuality() + 1);
	}

	private void decrementItemQualityByOne(Item item) {
		item.setQuality(item.getQuality() - 1);
	}

	private void setItemQualityToZero(Item item) {
		item.setQuality(0);
	}

	private void decrementItemSellInByOne(Item item) {
		item.setSellIn(item.getSellIn() - 1);
	}
}