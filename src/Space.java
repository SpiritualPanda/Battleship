public class Space {

    private int col;
    private int row;
    private boolean isOccupied;
    private boolean isGuessed;
    private Ship ship;

    public Space(int row, int col) {
        this.row = row;
        this.col = col;
        isGuessed = false;
        isOccupied = false;
    }

    public boolean hasShip() {
        return isOccupied;
    }

    public void layShip(Ship s) {
        isOccupied = true;
        ship = s;
    }

    public boolean guess() {
        isGuessed = true;
        return isOccupied;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Ship getShip() { return ship; }

    public String getShipType() { return ship.getName(); }

}
