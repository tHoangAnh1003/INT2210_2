package BaiTapThucHanh.Tuan3;

import java.util.*;

public class Buoi3 {
    
    public static int find(List<Integer> number, int target, int low, int high) {

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

        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(), target = input.nextInt();
        int low = input.nextInt(), high = input.nextInt();
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int value = input.nextInt();
            number.add(value);
        }

        System.out.println(find(number, target, low, high));


        input.close();
    }
}