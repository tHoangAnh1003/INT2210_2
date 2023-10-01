package HomeWork.Tuan3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        int answer = 0;
        
        for (int i = 0; i < q.size(); ++i) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    answer++;
                }
            }
        }
    
        System.out.println(answer);
    }  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = input.nextInt();
            List<Integer> number = new ArrayList<>();

            for (int j = 0; j < n; ++j) {
                int value = input.nextInt();
                number.add(value);
            }
            
            minimumBribes(number);
        }

        input.close();
    }
}
