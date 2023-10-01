package HomeWork.Tuan3;

import java.util.*;

public class binarySearch {
    
    public static int find(List<Integer> number, int target, int n) {
        int answer = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (number.get(low) + number.get(high) < target) {
                low = mid + 1;
            }
            else if (number.get(low) + number.get(high) > target) {
                high = mid - 1;
            }
            else { return mid; }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(), target = input.nextInt();
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int value = input.nextInt();
            number.add(value);
        }

        System.out.println(find(number, target, n));


        input.close();
    }
}
