//Code refactored by Mike Byrne
//	mjb187@pitt.edu

// CHANGES
//	- inventory integer: a binary representation of the inventory.
//		000 = no items
//		001 = sugar
//		010 = cream
//		011 = sugar, cream
//		100 = coffee
//		101 = coffee, sugar
//		110 = coffee, cream
//		111 = coffee, cream, sugar
//	- showInventory() and drink() return _inventory so that a return value can be evaluated
//	- the getX() methods return the boolean flag they set so that a return value can be evaluated

public class Player {

	private boolean _hasSugar = false;
	private boolean _hasCream = false;
	private boolean _hasCoffee = false;
	
	private int _inventory = 0;
	
	public Player() {
		
	}
	
	public boolean getSugar() {
		System.out.println("You found some sweet sugar!");
		_hasSugar = true;
		_inventory += 1;
		
		return _hasSugar;
	}
	
	public boolean getCream() {
		System.out.println("You found some creamy cream!");
		_hasCream = true;
		_inventory += 10;
		
		return _hasCream;
	}
	
	public boolean getCoffee() {
		System.out.println("You found some caffeinated coffee!");
		_hasCoffee = true;
		_inventory += 100;
		
		return _hasCoffee;
	}
	
	public boolean hasAllItems() {
		return (_hasCoffee && _hasCream && _hasSugar);
	}
	
	public int showInventory() {
		if (_hasCoffee) {
			System.out.println("You have a cup of delicious coffee.");
		} else {
			System.out.println("YOU HAVE NO COFFEE!");
		}
		if (_hasCream) {
			System.out.println("You have some fresh cream.");
		} else {
			System.out.println("YOU HAVE NO CREAM!");
		}
		if (_hasSugar) {
			System.out.println("You have some tasty sugar.");
		} else {
			System.out.println("YOU HAVE NO SUGAR!");
		}
		
		return _inventory;
	}
	
	public int drink() {
		showInventory();
		
		System.out.println();
		
		if (_hasCoffee && _hasCream && _hasSugar) {
			System.out.println("You drink the beverage and are ready to study!");
		} else if (_hasCoffee) {
			if (!_hasCream) {
				System.out.println("Without cream, you get an ulcer and cannot study.");
			} else {
				System.out.println("Without sugar, the coffee is too bitter.  You cannot study.");
			}
		} else if (_hasCream) {
			if (!_hasSugar) {
				System.out.println("You drink the cream, but without caffeine, you cannot study.");
			} else {
				System.out.println("You drink the sweetened cream, but without caffeine, you cannot study.");
			}
		} else if (_hasSugar) {
			System.out.println("You eat the sugar, but without caffeine, you cannot study.");
		} else {
			System.out.println("You drink the air, as you have no coffee, sugar, or cream.\n"
					+ "The air is invigorating, but not invigorating enough.  You cannot study.");
		}
		return _inventory;
	}
}
