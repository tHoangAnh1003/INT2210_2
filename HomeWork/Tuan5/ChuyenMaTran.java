package HomeWork.Tuan5;

import java.util.*;

public class ChuyenMaTran {

    static int m, n, q;

    static void chuyenHangNgang(int[][] matrix, int x, int y, int u, int v) {
        for (int i = x - 1; i < u; ++i) {
            reverseArray(matrix[i], y - 1, v - 1);
        }
    }

    static void chuyenHangDoc(int[][] matrix, int x, int y, int u, int v) {
        int[][] matrix2 = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix2[i][j] = matrix[j][i];
            }
        }

        for (int i = y - 1; i < v; ++i) {
            reverseArray(matrix2[i], x - 1, u - 1);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = m - 1; j >= 0; --j) {
                matrix[i][j] = matrix2[j][i];
            }
        }
    }

    static void reverseArray(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int k = 0; k < q; ++k) {
            int x, y, u, v, d;
            x = scanner.nextInt();
            y = scanner.nextInt();
            u = scanner.nextInt();
            v = scanner.nextInt();
            d = scanner.nextInt();

            if (d == 0) {
                chuyenHangDoc(matrix, x, y, u, v);
            } else {
                chuyenHangNgang(matrix, x, y, u, v);
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

