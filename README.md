# cmsc388t_winter21
# Project 1: PacMan

## Group 8:
Amarachi Joe-Nweke
Thomas Lu
Jyoti Michael D Rozario
Roger Luo

## Image of Pacman

![Pacman Image](https://i.imgur.com/HwENRZR.png)

## Running Game from Command Line

In order to run the game, 
```
javac -cp "src/" src/*.java //compile the code before start the game

java -cp "src/" StartMenu //Run GUI
```

## PacMan Class

Controls functionality of the player character.

### get_valid_moves()

Method returns an ArrayList of valid Locations that pacman can move to. A valid location is an empty location or a location with a cookie. To test this method, we picked a random location from the map and added the valid locations on the map to the ArrayList. This ArrayList was compared to the one returned by get valid moves to check their equality.

### move()

his method uses the get_valid_moves method to find the possible locations that PacMan can move, given his current location. The method then  chooses to move in one of those directions.

### is_ghost_in_range()
This method checks its surroundings to see if any Ghosts are in attack range. The attack radius of a ghost is 1 which means that a ghost at location  can attack PacMan as long as PacMan is located at . If any Ghosts are in the attack range, this method returns true otherwise it returns false.
The test for this method creates a NoFrame and adds Pacman at location (1,1) and a ghost at (1,2). Calling the ghost_in_range method returns true;

### consume()

This method checks to see if there is a 'power-cookie' located in Pacman's current coordinate. If there is, this method calls the eatCookie method from the Map Class, and returns a Jcomponent if the cookie a consumed. This method was tested by using a creating a NoFrame, then having a PacMan at (0,1). As this method should consume the token that PacMan is present on, the method should not return null.

## Map Class

Representation of the actual game board.

### move()
#### Description: 
The method takes a name, location, and type and put the object specified by the name at the location. If the function is able to successfull move the object it returns true, otherwise it returns false.
The test for this method creates a NoFrame and adds Pacman at location (1,1). Calling the move method to a new Location (1,2) updates the current location and returns true.

### getLoc()

This method returns what is in the specific location(Empty, Ghost, Pac-Man, Cookie, Wall). To test the method, we picked a random location on the map where a cookie was. Then we compared the type of the return value of the getLoc() method to ensure it was a cookie.

### attack()

Description: This method is called my attack() from Ghost class. When it is called, we assume the attack succeed since all the attacking requirement is confirmed in the Ghost class. Test for this method is add a ghost near by the PacMan and see it returns true or not.

### eatCookie()

The method controls Pacman eating a cookie. If it was able to successfully eat the cookie and update the display to do so return the corresponding JComponent, or null if no cookie was able to be eaten. This method was implemented in a way such that this method would only ever be called by Pacman.eatCookie() after the cooresponding checks have been made so there should be a cookie present. As thus, the test for this method has the same behavior as pacman.consume(), and was implemented with that same philosophy.

## Ghost Class

This class controls the functionality of the ghosts in PacMan.

### get_valid_moves()

This function returns an arraylist of possible locations that a ghost can move to from its current location. Ghosts cannot move through walls, but they can move through other ghosts or PacMan.

### move()
#### Description: 
This function uses the get_valid_moves function to find the possible locations that a ghost can move to from its current location and chooses to move in one of those directions. You are free to apply an algorithm here if you would like, but the only requirement is that you move in a valid direction. If the ghost is able to move, this function returns true otherwise it returns false.
The test for this method creates a NoFrame and adds Pacman at location (1,1) and a ghost at (1,2). Calling the move method returns true;

### is_pacman_in_range()

Description: This method checks all the valid moves at current position for the ghosts. Up, Down, Left, and Right, four directions are checked. If pacman is present in any of ghost's surrounding tiles, this method will return true, else false. This was tested by placing a NoFrame with a Pacman and a Ghost right next to each other, to see if the ghost will detect a pacman near it.

### attack()

This function checks to see if PacMan is in the attack range by using the is_pacman_in_range method and attacks PacMan if it is in range. This function returns true if the attack was successful and false otherwise. To test the method, we called attack and asserted true to ensure the attack happened.
