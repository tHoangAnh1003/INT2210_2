package HomeWork.Tuan5;

import java.util.*;

class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;  
    private int n;               

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}



public class EqualStacks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();

        int n = input.nextInt();
        int m = input.nextInt();
        int p = input.nextInt();


        for (int i = 0; i < n; ++i) {
            int val = input.nextInt();
            l1.add(val);
        }

        for (int i = 0; i < m; ++i) {
            int val = input.nextInt();
            l2.add(val);
        }

        for (int i = 0; i < p; ++i) {
            int val = input.nextInt();
            l3.add(val);
        }

        System.out.println(sovle(l1, l2, l3));

        input.close();
    }

    static int sovle(List<Integer> l1, List<Integer> l2, List<Integer> l3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;


        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        for (int i = l1.size() - 1; i >= 0; --i) {
            st1.push(l1.get(i));
            sum1 += l1.get(i);
        }

        for (int i = l2.size() - 1; i >= 0; --i) {
            st2.push(l2.get(i));
            sum2 += l2.get(i);
        }

        for (int i = l3.size() - 1; i >= 0; --i) {
            st3.push(l3.get(i));
            sum3 += l3.get(i);
        }


        while (!st1.isEmpty() || !st2.isEmpty() || !st3.isEmpty()) {
            if (sum1 > sum2 || sum1 > sum3) {
                int val = st1.pop();
                sum1 -= val;
            }
            else if (sum2 > sum1 || sum2 > sum3) {
                int val = st2.pop();
                sum2 -= val;
            }
            else if (sum3 > sum1 || sum3 > sum2) {
                int val = st3.pop();
                sum3 -= val;
            }
            else {
                return sum1;
            }
        }

        return 0;
    }
}
