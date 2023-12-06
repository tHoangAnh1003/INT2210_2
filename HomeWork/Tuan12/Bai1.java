package HomeWork.Tuan12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
public static int connectedCell(List<List<Integer>> matrix) {
                        int max = 0;
                        for (int i=0; i< matrix.size();i++) {
                                for (int j=0; j< matrix.get(i).size();j++) {
                                        if(matrix.get(i).get(j) == 1) {
                                                int curMax = recurCountConnected(i, j, matrix);
                                                max = Math.max(curMax, max);
                                        }
                                }
                        }
                        return max;
                }

private static int recurCountConnected(int i, int j, List<List<Integer>> matrix) {
    if (i < 0 || j < 0 || i >= matrix.size() || j >= matrix.get(i).size() || matrix.get(i).get(j)==0) {
        return 0;
    }
    int count = 0;
    if (matrix.get(i).get(j)==1) {
        count = 1;
        matrix.get(i).set(j, 0);
        count += recurCountConnected(i-1, j-1, matrix);
        count += recurCountConnected(i-1, j, matrix);
        count += recurCountConnected(i-1, j+1, matrix);
        count += recurCountConnected(i, j-1, matrix);
        count += recurCountConnected(i, j, matrix);
        count += recurCountConnected(i, j+1, matrix);
        count += recurCountConnected(i+1, j-1, matrix);
        count += recurCountConnected(i+1, j, matrix);
        count += recurCountConnected(i+1, j+1, matrix);
    }
    return count;

}

}

public class Bai1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
