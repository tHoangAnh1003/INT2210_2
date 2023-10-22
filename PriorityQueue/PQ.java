package PriorityQueue;

public interface PQ<Key extends Comparable> {
    void insert(Key key);
    Key delMax();
}
