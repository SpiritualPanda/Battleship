import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Battleship extends JFrame {

    private JPanel panelMain;

    private JButton fireButton1;
    private JButton fireButton2;
    private JButton fireButton3;
    private JButton fireButton4;
    private JButton fireButton5;
    private JButton fireButton6;
    private JButton fireButton7;
    private JButton fireButton8;
    private JButton fireButton9;
    private JButton fireButton10;
    private JButton fireButton11;
    private JButton fireButton12;
    private JButton fireButton13;
    private JButton fireButton14;
    private JButton fireButton15;
    private JButton fireButton16;
    private JButton fireButton17;
    private JButton fireButton18;
    private JButton fireButton19;
    private JButton fireButton20;
    private JButton fireButton21;
    private JButton fireButton22;
    private JButton fireButton23;
    private JButton fireButton24;
    private JButton fireButton25;
    private JButton fireButton26;
    private JButton fireButton27;
    private JButton fireButton28;
    private JButton fireButton29;
    private JButton fireButton30;
    private JButton fireButton31;
    private JButton fireButton32;
    private JButton fireButton33;
    private JButton fireButton34;
    private JButton fireButton35;
    private JButton fireButton36;
    private JButton fireButton37;
    private JButton fireButton38;
    private JButton fireButton39;
    private JButton fireButton40;
    private JButton fireButton41;
    private JButton fireButton42;
    private JButton fireButton43;
    private JButton fireButton44;
    private JButton fireButton45;
    private JButton fireButton46;
    private JButton fireButton47;
    private JButton fireButton48;
    private JButton fireButton49;
    private JButton fireButton50;
    private JButton fireButton51;
    private JButton fireButton52;
    private JButton fireButton53;
    private JButton fireButton54;
    private JButton fireButton55;
    private JButton fireButton56;
    private JButton fireButton57;
    private JButton fireButton58;
    private JButton fireButton59;
    private JButton fireButton60;
    private JButton fireButton61;
    private JButton fireButton62;
    private JButton fireButton63;
    private JButton fireButton64;
    private JLabel turnsLabel;
    private JLabel shipsLeftLabel;
    private Color defaultButtonColor;

    private static Board board;

    ArrayList<JButton> buttonList;

    private int turnsLeft;

    public Ship shipAt(int row, int col) {
        return board.getBoard()[row][col].getShip();
    }

    public void displayGameOver() {
        JOptionPane.showMessageDialog(this, "Game Over!");
    }

    public void displayWin() {
        JOptionPane.showMessageDialog(this, "Congratulations! You win!");
    }

    public void playSound(String url, int volume, int delayMS) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(Battleship.class.getResourceAsStream(url)));
            clip.open(inputStream);
            Thread.sleep(delayMS);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(volume * 0.01f));
            clip.start();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void newGame() {
        new Battleship("Battleship Game");
        for (JButton b : buttonList) {
            b.setEnabled(true);
            b.setText("Fire!");
            b.setBackground(defaultButtonColor);
        }
        turnsLeft = 25;
        turnsLabel.setText(String.valueOf(turnsLeft));
        shipsLeftLabel.setText(String.valueOf(5));
    }

    public Battleship(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);

        turnsLeft = 25;
        turnsLabel.setText(String.valueOf(turnsLeft));

        buttonList = new ArrayList<>();
        buttonList.add(fireButton1);
        buttonList.add(fireButton2);
        buttonList.add(fireButton3);
        buttonList.add(fireButton4);
        buttonList.add(fireButton5);
        buttonList.add(fireButton6);
        buttonList.add(fireButton7);
        buttonList.add(fireButton8);
        buttonList.add(fireButton9);
        buttonList.add(fireButton10);
        buttonList.add(fireButton11);
        buttonList.add(fireButton12);
        buttonList.add(fireButton13);
        buttonList.add(fireButton14);
        buttonList.add(fireButton15);
        buttonList.add(fireButton16);
        buttonList.add(fireButton17);
        buttonList.add(fireButton18);
        buttonList.add(fireButton19);
        buttonList.add(fireButton20);
        buttonList.add(fireButton21);
        buttonList.add(fireButton22);
        buttonList.add(fireButton23);
        buttonList.add(fireButton24);
        buttonList.add(fireButton25);
        buttonList.add(fireButton26);
        buttonList.add(fireButton27);
        buttonList.add(fireButton28);
        buttonList.add(fireButton29);
        buttonList.add(fireButton30);
        buttonList.add(fireButton31);
        buttonList.add(fireButton32);
        buttonList.add(fireButton33);
        buttonList.add(fireButton34);
        buttonList.add(fireButton35);
        buttonList.add(fireButton36);
        buttonList.add(fireButton37);
        buttonList.add(fireButton38);
        buttonList.add(fireButton39);
        buttonList.add(fireButton40);
        buttonList.add(fireButton41);
        buttonList.add(fireButton42);
        buttonList.add(fireButton43);
        buttonList.add(fireButton44);
        buttonList.add(fireButton45);
        buttonList.add(fireButton46);
        buttonList.add(fireButton47);
        buttonList.add(fireButton48);
        buttonList.add(fireButton49);
        buttonList.add(fireButton50);
        buttonList.add(fireButton51);
        buttonList.add(fireButton52);
        buttonList.add(fireButton53);
        buttonList.add(fireButton54);
        buttonList.add(fireButton55);
        buttonList.add(fireButton56);
        buttonList.add(fireButton57);
        buttonList.add(fireButton58);
        buttonList.add(fireButton59);
        buttonList.add(fireButton60);
        buttonList.add(fireButton61);
        buttonList.add(fireButton62);
        buttonList.add(fireButton63);
        buttonList.add(fireButton64);

        JButton[][] buttons = new JButton[8][8];
        int count = 0;
        for (int i=0; i < buttons.length; i++)
            for (int k=buttons[0].length-1; k >= 0; k--) { // Initializes buttons 2D Array
                buttons[i][k] = buttonList.get(count);
                count++;
            }

        board = new Board(); // This chunk lays down the 5 ships onto the board and displays it
        Ship destroyer = new Ship(2, "destroyer");
        Ship submarine = new Ship(3, "submarine");
        Ship cruiser = new Ship(3, "cruiser");
        Ship battleship = new Ship(4, "battleship");
        Ship carrier = new Ship(5, "carrier");
        System.out.println(board);
        System.out.println();
        board.layShip(carrier);
        board.layShip(battleship);
        board.layShip(cruiser);
        board.layShip(submarine);
        board.layShip(destroyer);
        System.out.println(board); // End chunk

        for (JButton[] arr : buttons) {
            for (JButton b : arr ) {
                b.addActionListener(e -> { // One of the buttons was clicked
                    if (defaultButtonColor == null) {
                        AbstractButton butt = (AbstractButton) e.getSource();
                        defaultButtonColor = butt.getBackground();
                    }
                    b.setEnabled(false);
                    String strRow = b.getToolTipText().substring(0,1);
                    String strCol = b.getToolTipText().substring(1);
                    int row = Integer.parseInt(strRow);
                    int col = Integer.parseInt(strCol);

                    board.getBoard()[row][col].guess();

                    if (board.isHit(row, col)) { // If there was a ship on the space clicked
                        b.setText("Hit!");
                        playSound("/resources/hit.wav", 20, 0);

                        b.setBackground(new Color(255, 50, 50));

                        shipAt(row, col).gotHit();
                        if (shipAt(row, col).isSunk()) { // If a given ship was sunk
                            board.decrementShips();
                            shipsLeftLabel.setText(String.valueOf(board.getShipsRemaining()));
                            playSound("/resources/Bubblessfx.wav", 100, 500);
                            int shipSize = shipAt(row, col).getSize();
                            switch (shipAt(row, col).getOrientation()) {
                                case "down":
                                    for (int i = shipAt(row, col).getStartRow(); i < shipAt(row, col).getStartRow() + shipSize; i++) // Display ship name
                                        buttons[i][col].setText(board.getBoard()[row][col].getShipType());

                                    break;
                                case "right":
                                    for (int i = shipAt(row, col).getStartCol(); i < shipAt(row, col).getStartCol() + shipSize; i++)
                                        buttons[row][i].setText(board.getBoard()[row][col].getShipType());

                                    break;
                                case "up":
                                    for (int i = shipAt(row, col).getStartRow(); i > shipAt(row, col).getStartRow() - shipSize; i--)
                                        buttons[i][col].setText(board.getBoard()[row][col].getShipType());

                                    break;
                                case "left":
                                    for (int i = shipAt(row, col).getStartCol(); i > shipAt(row, col).getStartCol() - shipSize; i--) {
                                        buttons[row][i].setText(board.getBoard()[row][col].getShipType());
                                    }

                                    break;
                            }
                        }
                        if (board.getShipsRemaining() == 0) { // Win condition
                            displayWin();
                            newGame();
                        }
                    }
                    else { // If there was no ship on the space clicked
                        b.setText("Miss!");
                        playSound("/resources/miss.wav", 30, 0);
                        turnsLeft--;
                        turnsLabel.setText(String.valueOf(turnsLeft));
                        if (turnsLeft == 0) { // If out of turns, Game Over screen and new game
                            displayGameOver();
                            newGame();
                        }
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        Battleship frame = new Battleship("Battleship Game");
        frame.setSize(700,500);
        frame.setVisible(true);
    }
}