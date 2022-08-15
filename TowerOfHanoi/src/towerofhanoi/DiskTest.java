// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

/**
 * Test class for Disk
 * 
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 03.10.2021
 */
public class DiskTest extends student.TestCase {

    private Disk disk1;
    private Disk disk2;

    /**
     * Sets up each test method.
     */
    public void setUp() {
        disk1 = new Disk(10);
        disk2 = new Disk(20);

    }


    /**
     * Ensures the method compareTo() is working as expected
     */
    public void testCompareTo() {
        Disk diskNull = null;
        Disk diskSmall = new Disk(5);
        Disk diskBig = new Disk(15);
        Disk diskEqual = new Disk(10);

        assertEquals(0, disk1.compareTo(diskEqual));
        assertEquals(-10, disk1.compareTo(diskBig));
        assertEquals(+10, disk1.compareTo(diskSmall));

        Exception exception = null;
        try {
            disk1.compareTo(diskNull);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("compareTo() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

    }


    /**
     * Ensures the method toString() is working as expected
     */
    public void testToString() {

        assertEquals("10", disk1.toString());
        assertEquals("20", disk2.toString());
    }


    /**
     * Ensures the method equals() is working as expected
     */
    public void testEquals() {

        Disk diskNull = null;
        Disk diskSmall = new Disk(5);
        Disk diskBig = new Disk(15);
        Disk diskEqual = new Disk(10);

        assertEquals(disk1, disk1);
        assertFalse(disk1.equals(diskNull));
        assertFalse(disk1.equals(new Object()));
        assertTrue(disk1.equals(diskEqual));
        assertFalse(disk1.equals(diskBig));
        assertFalse(disk1.equals(diskSmall));

    }

}
