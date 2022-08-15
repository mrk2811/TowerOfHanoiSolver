// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

import java.util.Observable;

/**
 * HanoiSolver class represents the Tower of Hanoi puzzle. It contains the
 * methods required solve this puzzle.
 * 
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 2021.03.12
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * Constructor
     * 
     * @param numDisks
     *            number of disks that Hanoi Tower will have
     */
    public HanoiSolver(int numDisks) {

        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);

    }


    /**
     * Returns number of disks
     * 
     * @return number of disks
     */
    public int disks() {

        return numDisks;
    }


    /**
     * Gets the Tower based on its position
     * 
     * @param pos
     *            Tower position
     * @return
     *         Tower in the specified position
     */
    public Tower getTower(Position pos) {

        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;

        }

    }


    /**
     * Returns disk width in each Tower as a string
     * 
     * @return
     *         String representation of disk width in each Tower
     */
    public String toString() {

        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * Moves the disk from one Tower to another and notifies observer
     * 
     * @param source
     *            Tower containing the disk to be moved
     * @param destination
     *            Tower where the disk will be moved to
     */
    private void move(Tower source, Tower destination) {

        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Solves the Tower of Hanoi puzzle
     * 
     * @param currentDisks
     *            Disks present in the tower of hanoi
     * @param startPole
     *            Tower representing the starting pole of the Tower of Hanoi
     * @param tempPole
     *            Tower representing the temporary pole of the Tower of Hanoi
     * @param endPole
     *            Tower representing the end pole of the Tower of Hanoi
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {

        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }

    }


    /**
     * Executes solveTowers() method with initialed parameters
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }

}
