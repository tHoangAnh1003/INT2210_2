package HomeWork.Tuan5;

import java.util.Iterator;
import java.util.NoSuchElementException;
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


public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        String text = "";
        Stack <String> oldVersion = new Stack<>();
        
        for (int i = 0; i < Q; i++) {
            int request = scanner.nextInt();
            
            switch (request) {
                case 1:
                {
                    oldVersion.push(text);

                    String append = scanner.next();
                    text += append;
                    break;
                }
                
                case 2:
                {
                    oldVersion.push(text);

                    int k = scanner.nextInt();

                    String newText = text.substring(0, text.length() - k);
                    text = newText;
                    break;
                }
                
                case 3:
                {
                    int k = scanner.nextInt();
                    System.out.println(text.charAt(k - 1));
                    break;
                }
                
                case 4:
                {
                    if (!oldVersion.isEmpty()) {
                        String oldText = oldVersion.peek();
                        oldVersion.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
        scanner.close();
    }
}