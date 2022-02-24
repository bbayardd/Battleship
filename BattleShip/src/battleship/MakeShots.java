package battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeShots {
    ArrayList<String> shortsFired = new ArrayList<>();

    public void shooting(Map map) {
        Draw print = new Draw(map);
        print.printMap();
        System.out.println("\nTake a shot!\n");
        boolean hit = false;
        while (!hit) {
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            int[] coordinates = commandToCoordinates(command);
            if (coordinates[0] < 1 || coordinates[0] > 10 ||
                    coordinates[1] < 1 || coordinates[1] > 10) {
                System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
                continue;
            } else {
                if (map.fire(coordinates)) {
                    System.out.println("\nYou hit a ship!\n");
                    print.printMap();
                    hit = true;
                } else {
                    print.printMap();
                    System.out.println("\nYou missed!\n");
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
