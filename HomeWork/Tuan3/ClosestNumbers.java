package HomeWork.Tuan3;

import java.util.*;

public class ClosestNumbers {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr, (a, b) -> a.compareTo(b));
        
        List<Integer> result = new ArrayList<>();
        int smallDif = Integer.MAX_VALUE;
        
        for (int i = 1; i < arr.size(); i++) {
            smallDif = Math.min(smallDif, arr.get(i) - arr.get(i - 1)); 
        }
        
        for (int i = 1; i < arr.size(); i++) {
            int dif = arr.get(i) - arr.get(i - 1);
            if (dif == smallDif) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int value = input.nextInt();
            number.add(value);
        }

        System.out.println(closestNumbers(number));

        input.close();
    }
}