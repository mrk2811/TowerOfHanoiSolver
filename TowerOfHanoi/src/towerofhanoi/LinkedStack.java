// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Muhammad Rehan Ali Khan (mrk2811)
package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

/**
 * The LinkedStack<T> class is an implementation of StackInterface<T>.
 * It implements all methods in the StackInterface and additional methods.
 * 
 * @param <T>
 *            The type of objects that the LinkedStack will hold.
 * 
 * @author Muhammad Rehan Ali Khan (mrk2811)
 * @version 2021.03.11
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int size;

    /**
     * Constructor
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * Gets the current size of the LinkedStack
     * 
     * @return size of LinkedStack
     */
    public int size() {
        return size;
    }


    /**
     * Removes all entries from the stack
     */
    @Override
    public void clear() {
        if (!isEmpty()) {
            topNode = null;
            size = 0;
        }
    }


    /**
     * Determines whether the stack is empty.
     * 
     * @return True if the stack is empty. Otherwise returns false.
     */
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }


    /**
     * Returns the stack's top entry without actually removing it from the
     * stack.
     * 
     * @return Returns the stack's top entry.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * Removes and returns stack's top entry.
     * 
     * @return Returns the stack's top entry.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T popedEntry = topNode.getData();
        topNode = topNode.getNextNode();
        size--;

        return popedEntry;
    }


    /**
     * Adds a new entry to the top of the stack.
     * 
     * @param anEntry
     *            anEntry is the new entry.
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<>(anEntry, topNode);
        topNode = newNode;
        size++;

    }


    /**
     * Returns a String representation of the array containing all entries in
     * the stack.
     * 
     * @return All entries in the stack as a String.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node<T> currentNode = topNode;
        while (currentNode != null) {
            if (s.length() > 1) {

                s.append(", ");

            }

            s.append(currentNode.getData());
            currentNode = currentNode.getNextNode();

        }
        s.append("]");
        return s.toString();
    }

    /**
     * Singly Linked Node
     * 
     * @author Rehan
     *
     * @param <T>
     */
    private class Node<T> {

        /**
         * Link to next node
         */
        private Node<T> next;

        /**
         * Stack entry
         */
        private T data;

        /**
         * Constructor
         * 
         * @param dataPortion
         *            The data to be stored in the node.
         */
        // This method is not used by the LinkedStack Class
        public Node(T dataPortion) {
            data = dataPortion;
        }


        /**
         * Constructor
         * 
         * @param dataPortion
         *            The data to be stored in the node.
         * @param nextNode
         *            The reference to the next node.
         */
        public Node(T dataPortion, Node<T> nextNode) {

            this(dataPortion);
            setNextNode(nextNode);

        }


        /**
         * Returns the next node
         * 
         * @return next node
         */
        public Node<T> getNextNode() {
            return next;
        }


        /**
         * Returns the data portion of the node
         * 
         * @return data portion of the node
         */
        public T getData() {
            return data;
        }


        /**
         * Sets the next node reference
         * 
         * @param nextNode
         *            next node reference
         */
        public void setNextNode(Node<T> nextNode) {
            next = nextNode;
        }
    }

}
