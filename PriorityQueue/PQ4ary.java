package PriorityQueue;

public class PQ4ary<Key extends Comparable> implements PQ<Key> {
    private Key[] a = (Key[]) (new Comparable[2]);
    private int N = 0;

    public void insert(Key key) {
        if (a.length == N) resize(a.length * 2);
        a[N] = key;
        swim(N++);
    }

    private void swim(int k) {
        while (k > 0) {
            int father = (k-1)>>2;
            if (!less(father, k)) break;
            exch(k, father);
            k = father;
        }
    }

    private void exch(int i, int j) {
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(int left, int right) {
        return a[left].compareTo(a[right]) < 0;
    }

    private void resize(int newLength) {
        Key[] a2 = (Key[]) (new Comparable[newLength]);
        for (int i = 0; i < N; i++)
            a2[i] = a[i];
        a = a2;
    }

    public Key delMax() {
        if (N<1) throw new IllegalStateException();
        Key max = a[0];
        a[0] = a[N-1];
        a[N-1] = null;
        N--;
        sink(0);
        if (N < a.length/4) resize(a.length/2);
        return max;
    }

    private void sink(int k) {
        while (4*k+1 <= N-1) {
            int maxChild = 4*k+1;
            int rightMost = 4*k+4;
            if (rightMost > N-1) rightMost = N-1;
            for (int i = 4*k+2; i <= rightMost; i++) {
                if (less(maxChild, i)) maxChild = i;
            }
            if (!less(k, maxChild)) break;
            exch(maxChild, k);
            k = maxChild;
        }
    }
    public void print() {
        for (int i = 0 ; i <= N; i++) System.err.print(" "+ a[i]);
        System.err.println(" ");
    }

}
