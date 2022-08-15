// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

/**
 * Test class for HanoiSolver
 * 
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 03.12.2021
 */
public class HanoiSolverTest extends student.TestCase {

    private HanoiSolver hanoi;

    /**
     * Sets up each test method.
     */
    public void setUp() {

        hanoi = new HanoiSolver(5);
    }


    /**
     * Ensures the method disks() is working as expected
     */
    public void testDisks() {
        assertEquals(5, hanoi.disks());
    }


    /**
     * Ensures the method getTower() is working as expected
     */
    public void testGetTower() {

        // Tower left = new Tower(Position.LEFT);
        // Tower middle = new Tower(Position.MIDDLE);
        // Tower right = new Tower(Position.RIGHT);

        hanoi.getTower(Position.LEFT).push(new Disk(20));
        hanoi.getTower(Position.MIDDLE).push(new Disk(30));
        hanoi.getTower(Position.RIGHT).push(new Disk(40));

        assertEquals("[20]", hanoi.getTower(Position.LEFT).toString());
        assertEquals("[30]", hanoi.getTower(Position.MIDDLE).toString());
        assertEquals("[40]", hanoi.getTower(Position.RIGHT).toString());
        assertEquals("[30]", hanoi.getTower(Position.DEFAULT).toString());
    }


    /**
     * Ensures the method toString() is working as expected
     */
    public void testToString() {
        assertEquals("[][][]", hanoi.toString());
    }


    /**
     * Ensures the method solve() is working as expected
     */
    public void testSolve() {
        assertEquals("[][][]", hanoi.toString());

        for (int i = hanoi.disks(); i >= 1; i--) {

            Disk disk = new Disk(i * 20);
            hanoi.getTower(Position.LEFT).push(disk);

        }

        assertEquals("[20, 40, 60, 80, 100][][]", hanoi.toString());
        hanoi.solve();
        assertEquals("[][][20, 40, 60, 80, 100]", hanoi.toString());
    }

}
