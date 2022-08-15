// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

import java.awt.Color;
import cs2.Shape;
import student.TestableRandom;

/**
 * The Disk class extends Shape class which implements Comparable<Disk>. This
 * class creates a disk to be used for Hanoi Tower.
 *
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 2021.03.10
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * Creates a Disk object with the provided width
     *
     * @param width
     *            width of the disk.
     */
    public Disk(int width) {

        super(0, 0, width, PuzzleWindow.DISK_HEIGHT, new Color(
            new TestableRandom().nextInt(256), new TestableRandom().nextInt(
                256), new TestableRandom().nextInt(256)));
    }


    /**
     * Compares width of two disks.
     *
     * @param otherDisk
     *            Other disk to be compared with.
     * @return 0 if width are equal. negative number if the disk is smaller then
     *         the otherDisk. Otherwise returns positive number. Throws
     *         IllegalArgumentException if the compared disk is null.
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }

        if (otherDisk.getWidth() == getWidth()) {
            return 0;
        }

        if (otherDisk.getWidth() > getWidth()) {
            return -getWidth();
        }

        return +getWidth();
    }


    /**
     * Returns width of the disk as a string
     *
     * @return String representation of the disk width.
     */
    public String toString() {

        return "" + getWidth();
    }


    /**
     * Two disks are equal if they have the same width
     *
     * @param givenDisk
     *            Other disk to be compared with for equality.
     * @return Returns true if the two disks have the same width.
     */
    @Override
    public boolean equals(Object givenDisk) {

        if (givenDisk == this) {
            return true;
        }
        if (givenDisk == null) {
            return false;
        }
        if (this.getClass() == givenDisk.getClass()) {
            Disk other = (Disk)givenDisk;
            return other.getWidth() == getWidth();

        }
        else {
            return false;
        }
    }

}
