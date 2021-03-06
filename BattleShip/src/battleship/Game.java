package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Scanner scan;
    List<Ship> ships;
    Map map;
    Draw draw;
    ArrayList<LocationShip> location;

    public Game(Map map, Draw draw, List<Ship> ships) {
        this.map = map;
        this.draw = draw;
        this.ships = ships;
        location = new ArrayList<LocationShip>();
    }

    public void start() {
        scan = new Scanner(System.in);
        draw.printMap();
        userInput();

    }

    public void userInput() {
        int i = 0;
        draw.inputRequest(ships.get(i));
        while (true) {
            String[] command = scan.nextLine().split(" ");
            if (!checkCommand(command, i))
                continue;
            if (!map.checkPos(command)) {
                draw.errorMesPlaceToClose();
                continue;
            }
            draw.printMap();
            location.add(new LocationShip(i, ships.get(i).getLength(), map.commandToCoordinate(command)));
            i++;
            if (i < ships.size()) {
                draw.inputRequest(ships.get(i));
            } else {
//                draw.mesStartGame();
                return;
            }
        }
    }

    public boolean checkCommand(String[] str, int shipIndex) throws ArrayIndexOutOfBoundsException {
        int num1;
        int num2;
        char letter1;
        char letter2;
        boolean returnValue = false;
        try {
            letter1 = str[0].charAt(0);
            letter2 = str[1].charAt(0);
            num1 = Integer.parseInt(str[0].substring(1));
            num2 = Integer.parseInt(str[1].substring(1));
        } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            return false;
        }

        boolean checkLetter = false;
        boolean checkNum = false;
        if (num1 >= 1 && num1 <= 10 && num2 <= 10 && num2 >= 1) {
            checkNum = true;
        }
        if (letter1 >= 'A' && letter1 <= 'J' && letter2 >= 'A' && letter2 <= 'J') {
            checkLetter = true;
        }
        if (checkNum && checkLetter) {
            String ship = ships.get(shipIndex).getTitle();
            int len = ships.get(shipIndex).getLength() - 1;
            if (letter1 - letter2 == 0) {
                if (Math.abs(num1 - num2) == len) {
                    returnValue =  true;
                }
            } else if (num1 - num2 == 0) {
                if (Math.abs((int) (letter1 - letter2))
                        == len ) {
                    returnValue = true;
                }
            }
        }
        if (!returnValue) {
            if (num1 - num2 != 0 && letter1 - letter2 != 0) {
                draw.errorMesWrongLocation();
            } else {
                draw.errorMesWrongLength();
            }
        }
        return returnValue;
    }
}
