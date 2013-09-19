package ar.fiuba.tecnicas.giledrose;

public class Inventory {
	/* TODO: ver si puedo acomodar estas definiciones en otro lugar más
	 * apropiado */
	private static final String NAME_BRIE = "Aged Brie";
	private static final String NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String NAME_BACKSTAGE =
			"Backstage passes to a TAFKAL80ETC concert";
	private static final String NAME_CAKE = "Conjured Mana Cake";

	/* TODO: Aplicar replace with primitive object */
	private static final int MIN_QUALITY = 0;
	private static final int MAX_QUALITY = 50;

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
		/* TODO: ver si puedo agrupar el update de cada item en una clase
		 * interna privada, para mayor ordenamiento y acortar el método */
		for (int i = 0; i < items.length; i++) {
			Item itemToUpdate = items[i];

			if (isItemConcertPasses(itemToUpdate)) {
				incrementItemQualityByOne(itemToUpdate);
				if (isItemSellInLessThanEleven(itemToUpdate)) {
					incrementItemQualityByOne(itemToUpdate);
				}
				if (isItemSellInLessThanSix(itemToUpdate)) {
					incrementItemQualityByOne(itemToUpdate);
				}
				decrementItemSellInByOne(itemToUpdate);
				if (isItemExpired(itemToUpdate)) {
					setItemQualityToZero(itemToUpdate);
				}
				return;
			}

			if (isItemSulfuras(itemToUpdate)) {
				return;
			}

			decrementItemSellInByOne(itemToUpdate);

			if (isItemAgedBrie(itemToUpdate)) {
				incrementItemQualityByOne(itemToUpdate);
				if (isItemExpired(itemToUpdate)) {
					incrementItemQualityByOne(itemToUpdate);
				}
				return;
			}

			if (isItemConjuredCake(itemToUpdate)) {
				decrementItemQualityByTwo(itemToUpdate);
				if (isItemExpired(itemToUpdate)) {
					decrementItemQualityByTwo(itemToUpdate);
				}
				return;
			}

			decrementItemQualityByOne(itemToUpdate);
			if (isItemExpired(itemToUpdate)) {
				decrementItemQualityByOne(itemToUpdate);
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

	private boolean isItemConjuredCake(Item item) {
		return item.getName() == NAME_CAKE;
	}

	private boolean isItemQualityGreaterThanMaximum(Item item) {
		return item.getQuality() > MAX_QUALITY;
	}

	private boolean isItemQualityLessThanMinimum(Item item) {
		return item.getQuality() < MIN_QUALITY;
	}

	private boolean isItemExpired(Item item) {
		return item.getSellIn() < 0;
	}

	private boolean isItemSellInLessThanSix(Item item) {
		return item.getSellIn() < 6;
	}

	private boolean isItemSellInLessThanEleven(Item item) {
		return item.getSellIn() < 11;
	}

	private void incrementItemQuality(Item item, int incrementInQuality) {
		item.setQuality(item.getQuality() + incrementInQuality);
		if (isItemQualityGreaterThanMaximum(item)) {
			item.setQuality(MAX_QUALITY);
		}
	}

	private void decrementItemQuality(Item item, int decrementInQuality) {
		item.setQuality(item.getQuality() - decrementInQuality);
		if (isItemQualityLessThanMinimum(item)) {
			item.setQuality(MIN_QUALITY);
		}
	}

	private void incrementItemQualityByOne(Item item) {
		incrementItemQuality(item, 1);
	}

	private void decrementItemQualityByOne(Item item) {
		decrementItemQuality(item, 1);
	}

	private void decrementItemQualityByTwo(Item item) {
		decrementItemQuality(item, 2);
	}

	private void setItemQualityToZero(Item item) {
		item.setQuality(0);
	}

	private void decrementItemSellInByOne(Item item) {
		item.setSellIn(item.getSellIn() - 1);
	}
}