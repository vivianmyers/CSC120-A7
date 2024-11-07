/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;

/**
 * Class Library extends the Building class and adds functionality including a
 * collection
 * of books
 */
public class Library extends Building {

  private static Hashtable<String, Boolean> collection;
  protected boolean hasElevator;

  /**
   * Library constructor
   * 
   * @param name    of library
   * @param address of library
   * @param nFloors number of floors in the library
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    collection = new Hashtable<>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * Default Library constructor
   */
  public Library() {
    super();
    collection = new Hashtable<>();
    this.hasElevator = true;
    System.out.println("You have built a library: 📖");
  }

  /**
   * Library constructor that allows for Elevator boolean
   * 
   * @param hasElevator
   */
  public Library(boolean hasElevator) {
    super();
    collection = new Hashtable<>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  // methods

  /**
   * Indicates if the collection has a certain title in it
   * 
   * @param title of the book we are looking for
   * @return true if the book is in the collection, false otherwise
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * Adds a new book to the collection if it isn't already there
   * 
   * @param title of the book we are trying to add
   */
  public void addTitle(String title) {
    try {
      if (containsTitle(title)) {
        throw new Exception("The book '" + title + "' is already in the collection.");
      } else {
        collection.put(title, true);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

  /**
   * Removes a book from the collection if it is in the collection
   * 
   * @param title of the book we want to remove
   * @return the title of the book
   */
  public String removeTitle(String title) {
    try {
      if (!containsTitle(title)) {
        throw new Exception("The book '" + title + "' is not in the collection.");
      } else {
        collection.remove(title, true);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    return title;
  }

  /**
   * Changes the status of a book from true to false if it is availible and in the
   * collection
   * 
   * @param title of the book we want to check out
   */
  public void checkOut(String title) {
    try {
      if (containsTitle(title) && isAvailable(title)) {
        collection.replace(title, true, false);
      } else {
        throw new Exception("Unable to checkout: " + title);
      }

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Changes status of a book from false to true if it is checked out and in the
   * collection
   * 
   * @param title of the book we want to return
   */
  public void returnBook(String title) {
    try {
      if (containsTitle(title) && !isAvailable(title)) {
        collection.replace(title, false, true);
      } else {
        throw new Exception("Unable to return: " + title);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

  /**
   * Checks if a book is in the collection and not checked out
   * 
   * @param title of book we are checking
   * @return true if the book is in the collection and not checked out, false
   *         otherwise
   */
  public boolean isAvailable(String title) {
    if (containsTitle(title) && collection.get(title)) {
      return true;
    }
    return false;
  }

  /**
   * Prints the collection with each title and its corresponding
   * availible/unavailible program
   */
  public void printCollection() {
    for (Map.Entry<String, Boolean> entry : collection.entrySet()) {
      String key = entry.getKey();
      Boolean value = entry.getValue();
      String status = value ? "Available" : "Not Available";
      System.out.printf("%-20s : %s%n", key, status);
    }
  }

  /**
   * @override this method prints a list of all availible methods
   */
  public void showOptions() {
    super.showOptions();
    System.out.print(
        " + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + isAvailible(title)\n + printCollection()\n");
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
    Library myLibrary = new Library("Smith College Library", "1 Chapin Way, Northampton, MA", 3, true);
    myLibrary.addTitle("hello");
    myLibrary.checkOut("hello");
    myLibrary.checkOut("hello");
    myLibrary.printCollection();

    myLibrary.showOptions();
  }

}