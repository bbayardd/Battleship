package battleship;

public class Draw {
    Map map;

    public Draw(Map map) {
        this.map = map;
    }

    public void printMap() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(map.field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void inputRequest(Ship type) {
        String output = String.format("\nEnter the coordinates of the %s (%d cells):\n", type.getTitle(), type.getLength());
        System.out.println(output);
    }
}
