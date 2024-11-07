import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * 
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * 
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " ("
                    + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        myMap.addBuilding(new Cafe());
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Elm St, Northampton, MA 01063", 4, 0, 0, 0, 0));
        myMap.addBuilding(new Cafe(100, 100, 100, 100));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "Chapin Way", 3, 100, 100, 50, 50));

        myMap.addBuilding(new House());
        myMap.addBuilding(new House(true, true));
        myMap.addBuilding(new House("Talbot", "25 Prospect St", 4, false, true));
        myMap.addBuilding(new House("Tyler", "Green St", 4, true, true));
        myMap.addBuilding(new House("Chapin", "Chapin Way", 4, true, false));

        myMap.addBuilding(new Library());
        myMap.addBuilding(new Library(true));
        myMap.addBuilding(new Library("Neilson Library", "7 Elm St", 5, true));
        myMap.addBuilding(new Library("Josten Library", "Green St", 2, true));
        System.out.println(myMap);
    }

}
