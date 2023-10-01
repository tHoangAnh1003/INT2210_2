package HomeWork.Tuan3;

import java.util.*;

public class SherlockandArray {

    public static String balancedSums(List<Integer> number, int n) {
        int sum = 0;

        for (int i = 0; i < n; ++i) { sum = sum + number.get(i); }
        
        int sumLeft = 0, sumRight = 0;

        for (int i = 0; i < n; i++) {
            sumRight = sum - sumLeft - number.get(i);
            if (sumLeft == sumRight) { return "YES"; }
            sumLeft = sumLeft + number.get(i);
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int value = input.nextInt();
            number.add(value);
        }

        System.out.println(balancedSums(number, n));

        input.close();
    }
}