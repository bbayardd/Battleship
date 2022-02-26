package battleship;

public class LocationShip {
    int name;
    int health;
    int[] coordinate;

    LocationShip(int name, int health, int[] coordinate) {
        this.name = name;
        this.health = health;
        this.coordinate = coordinate;
    }

    public boolean isAlive() {
        if (health > 0) {
            return true;
        }
        return false;
    }
}
