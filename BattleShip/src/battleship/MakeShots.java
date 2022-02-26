package battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeShots {
    Map map;
    ArrayList<LocationShip> location;
    Draw print;

    MakeShots(ArrayList<LocationShip> location, Map map) {
        this.map = map;
        this.location = location;
        this.print = new Draw(map);
    }

    public void shooting(Map map) {
        print.printHiddenMap();
        print.firstShot();
        boolean hit = false;
        while (!hit) {
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            int[] coordinates = commandToCoordinates(command);
            if (coordinates[0] < 1 || coordinates[0] > 10 ||
                    coordinates[1] < 1 || coordinates[1] > 10) {
                print.errorMesWrongCoordinateShot();
                continue;
            } else {
                if (map.fire(coordinates)) {
                    print.printHiddenMap();
                    for (int i = 0; i < location.size(); i++) {
                        if (location.get(i).coordinate[0] <= coordinates[0] && location.get(i).coordinate[2] >= coordinates[0]
                                && location.get(i).coordinate[1] <= coordinates[1] && location.get(i).coordinate[3] >= coordinates[1]) {
                            location.get(i).health--;
                            if (!location.get(i).isAlive()) {
                                location.remove(location.get(i));
                                if (location.isEmpty()) {
                                    print.congratulation();
                                    hit = true;
                                } else {
                                    print.findNewTarget();
                                }
                            } else {
                                print.niceShot();
                            }
                        }
                    }
                } else {
                    print.printHiddenMap();
                    print.wrongShot();
                }
            }
        }
    }

    public int[] commandToCoordinates(String command) {
        int[] coordinates = new int[2];
        coordinates[0] = (int)(command.charAt(0) - 64);
        coordinates[1] = Integer.parseInt(command.substring(1));
        return coordinates;
    }
}
