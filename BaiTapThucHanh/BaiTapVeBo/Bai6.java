package BaiTapThucHanh.BaiTapVeBo;

import java.util.*;

class MinPriorityQueue {
    private int[] arr;
    private int size;

    public MinPriorityQueue(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == arr.length) {
            return;
        }

        arr[size] = value;
        size++;

        heapifyUp();
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[0];
    }

    public int poll() {
        int minValue = arr[0];
        arr[0] = arr[size - 1];
        size--;

        heapifyDown();

        return minValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapifyUp() {
        int curIndex = size - 1;

        while (curIndex > 0) {
            int parIndex = (curIndex - 1) / 2;

            if (arr[curIndex] < arr[parIndex]) {
                int temp = arr[curIndex];
                arr[curIndex] = arr[parIndex];
                arr[parIndex] = temp;

                curIndex = parIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int curIndex = 0;

        while (true) {
            int leftIndex = 2 * curIndex + 1;
            int rightIndex = 2 * curIndex + 2;
            int minIndex = curIndex;

            if (leftIndex < size && arr[leftIndex] < arr[minIndex]) {
                minIndex = leftIndex;
            }
            if (rightIndex < size && arr[rightIndex] < arr[minIndex]) {
                minIndex = rightIndex;
            }

            if (minIndex != curIndex) {
                int temp = arr[curIndex];
                arr[curIndex] = arr[minIndex];
                arr[minIndex] = temp;

                curIndex = minIndex;
            } else {
                break;
            }
        }
    }
}


public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int val = sc.nextInt();

            arr.add(val);
        }

        System.out.println(cookies(k, arr));

        sc.close();
    }

    public static int cookies(int k, List<Integer> A) {
        int sze = A.size();
        MinPriorityQueue minQueue = new MinPriorityQueue(sze);

        for (int x : A) {
            minQueue.insert(x);
        }

        int count = 0;

        int minVal = minQueue.poll();
        while (minVal < k) {
            if (minQueue.isEmpty()) {
                return -1;
            }
            int minVal2 = minQueue.poll();
            minQueue.insert(minVal + 2 * minVal2);
            minVal = minQueue.poll();
            count += 1;
        }

        return count;
    }
}