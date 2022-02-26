package battleship;

public class Draw {
    Map map;

    public Draw(Map map) {
        this.map = map;
    }

    public void printMap() {
        System.out.println();
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

    public void printHiddenMap() {
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (map.field[i][j].equals("O")) {
                    System.out.print("~" + " ");
                } else {
                    System.out.print(map.field[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void errorMesWrongLocation() {
        System.out.println("\nError! Wrong ship location! Try again:\n");
    }

    public void errorMesWrongLength() {
        System.out.println("\nError! Wrong length of the Submarine! Try again:\n");
    }

    public void errorMesPlaceToClose() {
        System.out.println("\nError! You placed is too close to another one. Try again: \n");
    }

    public void mesStartGame() {
        System.out.println("\nThe game starts!\n");
    }

    public void firstShot() {
        System.out.println("\nTake a shot!\n");
    }

    public void errorMesWrongCoordinateShot() {
        System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
    }

    public void congratulation() {
        System.out.println("\nYou sank the last ship. You won. Congratulations!\n");
    }

    public void findNewTarget() {
        System.out.println("\nYou sank a ship! Specify a new target:\n");
    }

    public void niceShot() {
        System.out.println("\nYou hit a ship! Try again:\n");
    }

    public void wrongShot() {
        System.out.println("\nYou missed. Try again:\n");
    }
}
