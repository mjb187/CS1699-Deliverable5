//Code refactored by Mike Byrne
//	mjb187@pitt.edu

// CHANGES
//	- moveNorth() and moveSouth() now return the _currentRoom integer.
//	- added a getCurrentRoom() function that returns the _currentRoom integer.
//	- added a getHouseInfo() function that returns the _numRooms integer.
//	- reduced getCurrentRoomInfo() to only output String description
//	- moveNorth() and moveSouth() now verify that movement is possible
//	- House objects are now required to have at least one room, otherwise it defaults to six.

public class House {

	private int _numRooms = 6;
	
	private Room[] _rooms = new Room[_numRooms];
	
	private int _currentRoom = 0;
	
	public House(int numRooms) {
		if(numRooms > 0)
		{
			_numRooms = numRooms;
		}
		_rooms = generateRooms(_numRooms);
	}
	
	public int getHouseInfo() {
		return _numRooms;
	}
	
	public String getCurrentRoomInfo() {
		return _rooms[_currentRoom].getDescription();
	}
	
	public int moveNorth() {
		if(_rooms[_currentRoom].northExit())
			_currentRoom += 1;
		else
			System.out.println("There is no north door. You cannot move north.");
		return _currentRoom;
	}
	
	public int moveSouth() {
		if(_rooms[_currentRoom].southExit())
			_currentRoom -= 1;
		else
			System.out.println("There is no south door. You cannot move south.");
		return _currentRoom;
	}
	
	public int getCurrentRoom()
	{
		return _currentRoom;
	}
	
	public void look(Player player) {
		Room room = _rooms[_currentRoom];
		if (room.hasItem()) {
			System.out.println("There might be something here...");
			if (room.hasCoffee()) {
				player.getCoffee();
			}
			if (room.hasCream()) {
				player.getCream();
			}
			if (room.hasSugar()) {
				player.getSugar();
			}
		} else {
			System.out.println("You don't see anything out of the ordinary.");
		}
	}
	
	public Room[] generateRooms(int numRooms) {
				
		Room[] toReturn = new Room[numRooms];
		
		boolean northDoor = true;
		boolean southDoor = true;
		boolean hasCoffee = false;
		boolean hasCream = false;
		boolean hasSugar = false;
		
		for (int j = 0; j < numRooms; j++) {
			
			if (j == 0) { hasCream = true; } else {hasCream = false; };
			if (j == 2) { hasCoffee = true; } else {hasCoffee = false; };
			if (j == (numRooms - 1)) { hasSugar = true; } else { hasSugar = false; };
			
			if (j == 0) { southDoor = false; } else { southDoor = true; }
			if (j == (numRooms - 1)) { northDoor = false; } else { northDoor = true; }
			
			toReturn[j] = new Room(hasCoffee, hasCream, hasSugar, northDoor, southDoor);
		}
		
		return toReturn;
	}
	
	
}
