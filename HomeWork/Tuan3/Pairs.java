package HomeWork.Tuan3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Pairs {

    public static int pairs(int k, List<Integer> arr) {
        int count = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) set.add(num);
        
        for (int num : set) {
            if (set.contains(num + k)) { count += 1; }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(), k = input.nextInt();
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int value = input.nextInt();
            number.add(value);
        }

        System.out.println(pairs(k, number));

        input.close();
    }
}
