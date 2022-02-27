package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scan;

    public static void main(String[] args) {
        Map map = new Map(12, 12);
        Draw draw = new Draw(map, 1);
        draw.startGameMes();
        List<Ship> ships = List.of(Ship.AIRCRAFT,
                                    Ship.BATTLESHIP,
                                    Ship.SUBMARINE,
                                    Ship.CRUISER,
                                    Ship.DESTROYER);
        Game game = new Game(map, draw, ships);
        game.start();
        draw.passTheMove();
        Map map2 = new Map(12, 12);
        Draw draw2 = new Draw(map2, 2);
        draw2.startGameMes();
        Game game2 = new Game(map2, draw2,ships);
        game2.start();
        draw2.passTheMove();
        MakeShots fire = new MakeShots(game2.location, map, map2, 1, 2);
        MakeShots fire2 = new MakeShots(game.location, map2, map, 2, 1);
        while (!fire.flag || fire2.flag) {
            fire.shooting();
            fire2.shooting();
        }
    }
}
