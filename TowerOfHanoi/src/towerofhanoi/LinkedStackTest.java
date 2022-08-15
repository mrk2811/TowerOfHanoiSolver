// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

import java.util.EmptyStackException;

/**
 * Test class for LinkedStack
 * 
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 03.11.2021
 */
public class LinkedStackTest extends student.TestCase {

    private LinkedStack<String> stack;

    /**
     * Sets up each test method.
     */
    public void setUp() {

        stack = new LinkedStack<>();
    }


    /**
     * Ensures the method size() is working as expected
     */
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push("Disk1");
        assertEquals(1, stack.size());

        stack.push("Disk2");
        assertEquals(2, stack.size());

    }


    /**
     * Ensures the method clear() is working as expected
     */
    public void testClear() {

        assertEquals(0, stack.size());
        stack.clear();
        assertEquals(0, stack.size());

        stack.push("Disk1");
        stack.push("Disk2");
        stack.clear();

        assertEquals(0, stack.size());

    }


    /**
     * Ensures the method isEmpty() is working as expected
     */
    public void testIsEmpty() {

        assertTrue(stack.isEmpty());

        stack.push("Disk1");
        assertFalse(stack.isEmpty());

    }


    /**
     * Ensures the method peek() is working as expected
     */
    public void testPeek() {

        Exception exception = null;
        try {
            stack.peek();
            fail("peek() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("peek() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);

        stack.push("Disk1");
        stack.push("Disk2");
        assertEquals("Disk2", stack.peek());
        assertEquals(2, stack.size());

    }


    /**
     * Ensures the method pop() is working as expected
     */
    public void testPop() {

        Exception exception = null;
        try {
            stack.pop();
            fail("pop() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("pop() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);

        stack.push("Disk1");
        stack.push("Disk2");
        assertEquals("Disk2", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("Disk1", stack.pop());
        assertEquals(0, stack.size());

    }


    /**
     * Ensures the method push() is working as expected
     */
    public void testPush() {
        assertEquals(0, stack.size());
        stack.push("Disk1");
        assertEquals(1, stack.size());
        assertEquals("Disk1", stack.peek());

        stack.push("Disk2");
        assertEquals(2, stack.size());
        assertEquals("Disk2", stack.peek());
    }


    /**
     * Ensures the method toString() is working as expected
     */
    public void testToString() {

        assertEquals("[]", stack.toString());

        stack.push("Disk1");
        stack.push("Disk2");
        stack.push("Disk3");
        stack.push("Disk4");

        assertEquals("[Disk4, Disk3, Disk2, Disk1]", stack.toString());

    }

}
