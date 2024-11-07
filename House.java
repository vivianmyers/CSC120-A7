/* This is a stub for the House class */

import java.util.ArrayList;

/**
 * The House class extends the Building class and adds functionality involving
 * dining rooms and residents.
 */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  protected boolean hasElevator;

  /**
   * House Constructor
   * 
   * @param name      is the building name
   * @param address   is the building address
   * @param nFloors   is the number of floors
   * @param hasDining indicates whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDining, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDining;
    this.hasElevator = hasElevator;

    System.out.println("You have built a house: 🏠");
  }

  /**
   * Default House Constructor
   */
  public House() {
    super();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * House constructor that sets dining and elevator status
   * 
   * @param hasDining   indicates whether the house has a dining room
   * @param hasElevator indicates whether the house has a elevator
   */
  public House(boolean hasDining, boolean hasElevator) {
    super();
    this.hasDiningRoom = hasDining;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Indicates if the house has a dining room
   * 
   * @return True if it does, flase otherwise
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Returns the size of the residents list
   * 
   * @return size of residents
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Checks if a person is in the residents list
   * 
   * @param person is the person we are looking for in the residents list
   * @return True if the person is in residents, false otherwise
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  /**
   * Adds a new resident to the resident list if they dont already live there
   * 
   * @param name of the person we would like to add
   */
  public void moveIn(String name) {
    try {
      if (!isResident(name)) {
        residents.add(name);
      } else {
        throw new Exception(name + "already lives here.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Removes a person from residents if they are on the list
   * 
   * @param name of the person we want to remove
   * @return the name of the person removed
   */
  public String moveOut(String name) {
    try {
      if (isResident(name)) {
        residents.remove(name);
      } else {
        throw new Exception(name + " does not live here.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    return name;
  }

  /**
   * @override this method prints a list of all availible methods
   */
  public void showOptions() {
    super.showOptions();
    System.out.print(" + moveIn(name)\n + moveOut(name)\n");
  }

  /**
   * @override This method overrides the parent and checks if there is an elevator
   *           before moving
   */
  public void goToFloor(int n) {
    if (this.activeFloor == -1) {
      throw new RuntimeException(
          "You are not inside this Building. Must call enter() before navigating between floors.");
    }

    if (n < 1 || n > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
    }

    if (!hasElevator && Math.abs(n - activeFloor) > 1) {
      throw new RuntimeException("Cannot move more than one floor without an elevator.");
    } else {
      System.out.println("You are now on floor #" + n + " of " + this.name);
      this.activeFloor = n;
    }
  }

  /**
   * Main method for testing
   * 
   * @param args
   */
  public static void main(String[] args) {
    House house = new House("myHouse", "948 New Boston", 2, true, true);
    house.moveIn("Vivian");
    System.out.println(house);
    house.showOptions();
  }

}