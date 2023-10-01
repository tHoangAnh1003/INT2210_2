package HomeWork.Tuan2;

import java.util.*;

public class threeSum {

    public static int countThreeSum(List<Integer> number, int n) {
        int count = 0;

        for (int i = 0; i < n - 1; ++i) {
            int low = i + 1, high = n - 1;
            int zero = 0 - number.get(i);

            while (low < high) {
                if (number.get(low) + number.get(high) > zero) {
                    high -= 1;
                }
                else if (number.get(low) + number.get(high) < zero) {
                    low += 1;
                }
                else {
                    low += 1;
                    high -= 1;
                    count += 1;
                }
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

        System.out.println(countThreeSum(number, n));

        input.close();
    }
}
