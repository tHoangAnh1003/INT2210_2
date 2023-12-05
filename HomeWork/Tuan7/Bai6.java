package HomeWork.Tuan7;

import java.io.*;
import java.util.*;

public class Bai6 {
    static int partition(int[] arr, int low, int high) {
        int pivotCorrectIdx = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= arr[high]) {
                swap(arr, i, pivotCorrectIdx);
                pivotCorrectIdx++;
            }
        }
        swap(arr, high, pivotCorrectIdx);
        printArr(arr);
        return pivotCorrectIdx;
    }

    static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIdx = partition(arr, low, high);
        sort(arr, low, pivotIdx - 1);
        sort(arr, pivotIdx + 1, high);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr, 0, n - 1);
    }
}
