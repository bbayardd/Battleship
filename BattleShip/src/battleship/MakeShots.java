package battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeShots {
    Map map;
    Map map2;
    ArrayList<LocationShip> location;
//    ArrayList<LocationShip> location2;
    Draw print;
    Draw print2;
    boolean flag;

    MakeShots(ArrayList<LocationShip> location, Map map, Map map2, int p1, int p2) {
        this.map = map;
        this.map2 = map2;
        this.location = location;
//        this.location2 = location2;
        this.print = new Draw(map, p1);
        this.print2 = new Draw(map2, p2);
        this.flag = false;
    }

    public void shooting() {
        print2.printHiddenMap();
        print.printMapWithShoot();
        print.playerTurn();
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
                if (map2.fire(coordinates)) {
//                    print.printHiddenMap();
                    for (int i = 0; i < location.size(); i++) {
                        if (location.get(i).coordinate[0] <= coordinates[0] && location.get(i).coordinate[2] >= coordinates[0]
                                && location.get(i).coordinate[1] <= coordinates[1] && location.get(i).coordinate[3] >= coordinates[1]) {
                            if (!map2.doubleFire) {
                                location.get(i).health--;
                            }
                            if (!location.get(i).isAlive()) {
                                location.remove(location.get(i));
                                if (location.isEmpty()) {
                                    print.congratulation();
                                    flag = true;
                                } else {
                                    print.findNewTarget();
                                }
                            } else {
                                print.niceShot();
                            }
                        }
                    }
                } else {
//                    print.printHiddenMap();
                    print.wrongShot();
                }
                hit = true;
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
