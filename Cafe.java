/**
 * Class Cafe extends class Building and manages an inventory of coffee, sugar,
 * cream, and cups as well
 * as methods to manage them and sell coffee
 */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Cafe constructor
     * 
     * @param name    name of cafe
     * @param address address of cafe
     * @param nFloors number of floors
     * @param coffee  ounces of coffee
     * @param sugar   number of sugaar packets
     * @param cream   number of creams
     * @param cups    number of cups
     */
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Default Cafe constructor
     */
    public Cafe() {
        super();
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
    }

    /**
     * Cafe constructor that only sets inventory amounts
     * 
     * @param coffee ounces of coffee
     * @param sugar  number of sugaar packets
     * @param cream  number of creams
     * @param cups   number of cups
     */
    public Cafe(int coffee, int sugar, int cream, int cups) {
        super();
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
    }

    // methods

    /**
     * Creates and sells a coffee by removing given amounts of each material,
     * restocks with exact amounts needed for a coffee
     * if there is not enough stock to make that coffee
     * 
     * @param size          coffee ounces needed for a coffee
     * @param nSugarPackets number of sugar packets needed for a coffee
     * @param nCreams       number of creams needed for a coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {

        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams
                || this.nCups < 1) {
            System.out.println("Not enough stock: Restocking...");
            restock(nCoffeeOunces, nSugarPackets, nCreams, 50);
        }

        System.out.println("Making coffee!");
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups--;

    }

    /**
     * Restocks the cafe with nessecary amounts to make the requested coffee
     * 
     * @param nCoffeeOunces number of coffee ounces to restock
     * @param nSugarPackets number of sugar packets to restock
     * @param nCreams       number of creams to restock
     * @param nCups         number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Restocks the cafe with default amounts
     */
    private void restock() {
        this.nCoffeeOunces += 100;
        this.nSugarPackets += 50;
        this.nCreams += 50;
        this.nCups += 50;
    }

    /**
     * @override this method prints a list of all availible methods
     */
    public void showOptions() {
        super.showOptions();
        System.out.print(
                " + sellCoffee(size, nSugarPackets, nCreams)\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)\n");
    }

    /**
     * @override This method overrides the parent and restricts movement that
     *           requires an elevator
     */
    public void goToFloor(int n) {
        if (this.activeFloor == -1) {
            throw new RuntimeException(
                    "You are not inside this Building. Must call enter() before navigating between floors.");
        }

        if (n < 1 || n > this.nFloors) {
            throw new RuntimeException(
                    "Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
        }

        if (Math.abs(n - this.activeFloor) > 1) {
            throw new RuntimeException("Unable to go to floor " + n + ": Cafes do not have elevators.");
        }

        System.out.println("You are now on floor #" + n + " of " + this.name);
        this.activeFloor = n;

    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "1 Chapin Way", 3, 0, 0, 0, 0);
        compassCafe.sellCoffee(5, 2, 0);
        compassCafe.showOptions();
        compassCafe.enter();
        compassCafe.goToFloor(4);

    }

}
