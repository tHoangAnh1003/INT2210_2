package HomeWork.Tuan6;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
        int last = arr.get(arr.size() - 1);
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (i > 0 && last < arr.get(i - 1)) {
                arr.set(i, arr.get(i - 1));
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            } else {
                arr.set(i, last);
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
                break;
            }
        }

    }

}

public class InsertionSortPart1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}

