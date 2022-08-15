// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

/**
 * Test class for Tower
 * 
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 03.15.2021
 */
public class TowerTest extends student.TestCase {

    private Tower tower;

    /**
     * Sets up each test method.
     */
    public void setUp() {

        tower = new Tower(Position.LEFT);
    }


    /**
     * Ensures the method position() is working as expected
     */
    public void testPosition() {

        assertEquals(tower.position(), Position.LEFT);
    }


    /**
     * Ensures the method push() is working as expected
     */
    public void testPush() {

        Disk disknull = null;
        Exception exception = null;
        try {
            tower.push(disknull);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

        tower.push(new Disk(20));
        assertEquals(1, tower.size());

        tower.push(new Disk(10));
        assertEquals(2, tower.size());

        exception = null;
        try {
            tower.push(new Disk(20));
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalStateException);

    }

}
