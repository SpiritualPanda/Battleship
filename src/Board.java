// The "Board" is a 8x8 2D Array of Spaces, which simulates a standard Battleship board.

public class Board {

    private final Space[][] board = new Space[8][8];
    private int shipsRemaining = 0;

    public Board() {
        for (int i=0; i < 8; i++) {
            for (int k=0; k < 8; k++) {
                board[i][k] = new Space(i, k);
            }
        }
    }

    public Space[][] getBoard() {
        return board;
    }

    public int getShipsRemaining() {
        return shipsRemaining;
    }
    public void decrementShips() {
        shipsRemaining--;
    }

    public boolean isHit(int row, int col) {
        return board[row][col].hasShip();
    }
    public int newRandInt() {
        return (int) (Math.random() * 4);
    }

    public void layShip(Ship s)  { // Lay down a ship with random pos and orientation on the Board
        int rand = newRandInt();
        boolean found = false;

        do {
            boolean restart = false;
            if (rand == 0) { // Check left
                if (s.getStartCol() - s.getSize() + 1 >= 0) { // If there is room...
                    for (int i = s.getStartCol(); i >= s.getStartCol() - s.getSize() + 1; i--) {
                        if (board[s.getStartRow()][i].hasShip()) { // If one of the spaces is already occupied
                            restart = true;
                            break;
                        }
                    }
                    if (restart) {
                        s.newPos();
                        rand = newRandInt();
                        continue;
                    }
                    for (int i = s.getStartCol(); i >= s.getStartCol() - s.getSize() + 1; i--) { // Lay down the ship
                        board[s.getStartRow()][i].layShip(s);
                        board[s.getStartRow()][i].getShip().setOrientation("left");
                    }
                    shipsRemaining++;
                    System.out.println("Laid "+s.getSize()+" left at " + s.getStartRow() + ", " + s.getStartCol());
                    found = true;
                } else { // If no room, then
                    rand = newRandInt(); // generate another randInt and repeat
                }
            } else if (rand == 1) { // Check down
                if (s.getStartRow() + s.getSize() - 1 <= 7) {
                    for (int i = s.getStartRow(); i <= s.getStartRow() + s.getSize() - 1; i++) {
                        if (board[i][s.getStartCol()].hasShip()) { // Check if there is no ship there already
                            restart = true;
                            break;
                        }
                    }
                    if (restart) { // If there is, try again.
                        s.newPos();
                        rand = newRandInt();
                        continue;
                    }
                    for (int i = s.getStartRow(); i <= s.getStartRow() + s.getSize() - 1; i++) {
                        board[i][s.getStartCol()].layShip(s);
                        board[i][s.getStartCol()].getShip().setOrientation("down");
                    }
                    shipsRemaining++;
                    System.out.println("Laid "+s.getSize()+" down at " + s.getStartRow() + ", " + s.getStartCol());
                    found = true;
                }
                else {
                    rand = newRandInt();
                }
            } else if (rand == 2) { // Check right
                if (s.getStartCol() + s.getSize() - 1 <= 7) {
                    for (int i = s.getStartCol(); i <= s.getStartCol() + s.getSize() - 1; i++) {
                        if (board[s.getStartRow()][i].hasShip()) {
                            restart = true;
                            break;
                        }
                    }
                    if (restart) {
                        s.newPos();
                        rand = newRandInt();
                        continue;
                    }
                    for (int i = s.getStartCol(); i <= s.getStartCol() + s.getSize() - 1; i++) {
                        board[s.getStartRow()][i].layShip(s);
                        board[s.getStartRow()][i].getShip().setOrientation("right");
                    }
                    shipsRemaining++;
                    System.out.println("Laid "+s.getSize()+" right at " + s.getStartRow() + ", " + s.getStartCol());
                    found = true;
                }
                else {
                    rand = newRandInt();
                }
            } else if (rand == 3) { // Check up
                if (s.getStartRow() - s.getSize() + 1 >= 0) {
                    for (int i = s.getStartRow(); i >= s.getStartRow() - s.getSize() + 1; i--) {
                        if (board[i][s.getStartCol()].hasShip()) {
                            restart = true;
                            break;
                        }
                    }
                    if (restart) {
                        s.newPos();
                        rand = newRandInt();
                        continue;
                    }
                    for (int i = s.getStartRow(); i >= s.getStartRow() - s.getSize() + 1; i--) {
                        board[i][s.getStartCol()].layShip(s);
                        board[i][s.getStartCol()].getShip().setOrientation("up");
                    }
                    shipsRemaining++;
                    System.out.println("Laid "+s.getSize()+" up at " + s.getStartRow() + ", " + s.getStartCol());
                    found = true;
                }
                else {
                    rand = newRandInt();
                }
            }
        } while (!found); // The loop continues until the ship is successfully laid down.
    }

    public String toString() { // Prints out the board (X's are ships, O's are empty)
        StringBuilder result = new StringBuilder();
        for (Space[] out : board) {
            for (Space has : out) {
                if (has.hasShip())
                    result.append(" X ");
                else
                    result.append(" O ");
            }
            result.append("\n");
        }
        return result.toString();
    }

}
