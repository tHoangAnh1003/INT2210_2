package HomeWork.Tuan2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class twoSum {
    public static int countTwoSum(List<Integer> number, int n) {
        int count = 0;

        int low = 0, high = n - 1;

        while (low < high) {
            if (number.get(low) + number.get(high) < 0) { low += 1; }
            else if (number.get(low) + number.get(high) > 0) { high -= 1; }
            else {
                count += 1;
                low += 1;
                high -= 1;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int value = input.nextInt();
            number.add(value);
        }

        Collections.sort(number, (a, b) -> a.compareTo(b));

        System.out.println(countTwoSum(number, n));

        input.close();
    }
}
