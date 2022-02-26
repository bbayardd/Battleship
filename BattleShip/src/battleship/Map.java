package battleship;

public class Map {
    String[][] field;

    public Map(int x, int y) {
        this.field = new String[x][y];
        initMap();
    }


    public void initMap() {
        int height = field.length;
        int width;
        for (int i = 0; i < height; i++) {
            width = field[i].length;
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) {
                    field[i][j] = " ";
                } else if (i == 0) {
                    field[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    field[i][j] = String.valueOf((char) (i + 64));
                } else {
                    field[i][j] = "~";
                }
            }
        }
    }

    public boolean checkPos(String[] command) {
        int[] coordinate = commandToCoordinate(command);
        for (int i = coordinate[0] - 1; i <= coordinate[2] + 1; i++) {
            for (int j = coordinate[1] - 1; j <= coordinate[3] + 1; j++) {
                if (field[i][j].equals("O")) {
                    return false;
                }
            }
        }
            for (int i = coordinate[0]; i <= coordinate[2]; i++) {
                for (int j = coordinate[1]; j <= coordinate[3]; j++) {
                    field[i][j] = "O";
                }
            }
        return true;
    }

    public int[] commandToCoordinate(String[] command) {
        int[] coordinate = new int[4];
        coordinate[0] = (int)(command[0].charAt(0) - 64);
        coordinate[1] = Integer.parseInt(command[0].substring(1));
        coordinate[2] = (int)(command[1].charAt(0) - 64);
        coordinate[3] = Integer.parseInt(command[1].substring(1));
        int tranzit;
        if (coordinate[0] > coordinate[2] || coordinate[1] > coordinate[3]) {
            tranzit = coordinate[0];
            coordinate[0] = coordinate[2];
            coordinate[2] = tranzit;
            tranzit = coordinate[1];
            coordinate[1] = coordinate[3];
            coordinate[3] = tranzit;
        }
        return coordinate;
    }

    public boolean fire(int[] coordinate) {
        if (field[coordinate[0]][coordinate[1]].equals("O") ||
                field[coordinate[0]][coordinate[1]].equals("X")) {
            field[coordinate[0]][coordinate[1]] = "X";
            return true;
        } else {
            field[coordinate[0]][coordinate[1]] = "M";
            return false;
        }
    }
}
