package battleship;

import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scan;

    public static void main(String[] args) {
        Map map = new Map(12, 12);
        Draw draw = new Draw(map);
        List<Ship> ships = List.of(Ship.AIRCRAFT,
                                    Ship.BATTLESHIP,
                                    Ship.SUBMARINE,
                                    Ship.CRUISER,
                                    Ship.DESTROYER);
        Game game = new Game(map, draw, ships);
        game.start();
        MakeShots fire = new MakeShots();
        fire.shooting(map);

    }
}
