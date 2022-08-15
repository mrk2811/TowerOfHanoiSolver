// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * PuzzleWindow class creates the window to view the hanoi puzzle and observes
 * HanoiSolver
 * 
 * @author Muhammad Rehan Ali Khan
 * @version 2021.03.15
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    Window window;
    // private static final int WIDTH_FACTOR = 1;
    private static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 8;

    /**
     * Constructor
     * 
     * Creates the window, adds the poles and shapes
     * 
     * @param game
     *            HanoiSolver to be displayed
     */
    public PuzzleWindow(HanoiSolver game) {

        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");

        left = new Shape(100, 100, 4, 100, java.awt.Color.BLACK);
        right = new Shape(500, 100, 4, 100, java.awt.Color.BLACK);
        middle = new Shape(300, 100, 4, 100, java.awt.Color.BLACK);

        for (int i = game.disks(); i >= 1; i--) {

            Disk disk = new Disk(i * 20);
            window.addShape(disk);
            game.getTower(Position.LEFT).push(disk);
            moveDisk(Position.LEFT);

        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }


    /**
     * To pause between disk movements
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * Executes HanoiSolver's solve() method when the specified button is
     * clicked
     * 
     * @param button
     *            Button to execute the solve() method
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * Helper method for update() that creates poles moves the disk position on
     * the window
     */
    private void moveDisk(Position position) {

        Disk currentDisk;
        Shape currentPole;
        currentDisk = game.getTower(position).peek();

        if (position == Position.LEFT) {
            currentPole = left;

        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }
        else if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        else {
            currentPole = middle;
        }

        int newDiskXPos = currentPole.getX() + ((currentPole.getWidth()
            - currentDisk.getWidth()) / 2);

        int newDiskYPos = (currentPole.getY() + currentPole.getHeight()) - (game
            .getTower(position).size() + 1) * (DISK_HEIGHT + DISK_GAP);
        currentDisk.moveTo(newDiskXPos, newDiskYPos);

    }


    /**
     * Updates the disk position on the window based on the Observable
     * 
     * @param o
     *            Observable
     * @param arg
     *            The position
     */
    public void update(Observable o, Object arg) {

        if (arg.getClass() == (Position.class)) {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }

    }

}
