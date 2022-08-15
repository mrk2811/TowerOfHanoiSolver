// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

/**
 * The Tower class extends LinkedStack<Disk>
 * It defines the tower position and allows only smaller disks to be placed on
 * top of larger ones
 * 
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 2021.03.11
 */
public class Tower extends LinkedStack<Disk> {

    private Position position;

    /**
     * Constructor
     * 
     * @param position
     *            position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;

    }


    /**
     * Gets the tower position
     * 
     * @return Tower position
     */
    public Position position() {
        return position;
    }


    /**
     * Overrides LinkedStack's push() method. A push is only valid if the tower
     * is empty or the disk on top is larger than the disk being pushed.
     * 
     * @param disk
     *            disk being pushed
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || peek().compareTo(disk) > 1) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }

}
