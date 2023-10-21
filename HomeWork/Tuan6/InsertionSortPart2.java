package HomeWork.Tuan6;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
    // Write your code here
        for (int index = 1; index < n; index++) {
            int value = arr.get(index);
            int position = index - 1;

            while (position >= 0 && arr.get(position) > value) {
                arr.set(position + 1, arr.get(position));
                position--;
            }

            arr.set(position + 1, value);
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

}

public class InsertionSortPart2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}

