// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

/**
 * ProjectRunner class has the main method to run the HanoiSolver game
 * 
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 03.15.2021
 */
public class ProjectRunner {

    public static void main(String[] args) {

        int disks = 4;

        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow puzzle = new PuzzleWindow(hanoi);

    }

}
