// The Ship object has fields such as size, type, and orientation. The ships are laid with
// the layShip() method in Board.

public class Ship {

    final private int size;
    final private String name;
    private String orientation = "";
    private int spacesLeft;

    private int startRow = (int) (Math.random() * 7);
    private int startCol = (int) (Math.random() * 7);

    public int getSize() {
        return size;
    }

    public int getSpacesLeft() { return spacesLeft; }

    public void gotHit() {
        spacesLeft--;
    }

    public boolean isSunk() { return (spacesLeft == 0); }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public void newPos() {
        startRow = (int) (Math.random() * 7);
        startCol = (int) (Math.random() * 7);
    }

    public String getName() {
        return name;
    }

    public String getOrientation() { return orientation; }

    public void setOrientation(String orientation) { this.orientation = orientation; }

    public Ship(int size, String name) {
        this.size = size;
        this.name = name;
        spacesLeft = size;
    }

}
