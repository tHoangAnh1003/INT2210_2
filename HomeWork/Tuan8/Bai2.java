package HomeWork.Tuan8;

import java.io.*;
import java.util.*;

public class Bai2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        
        String s = input.nextLine();
    
        if (checkString(s)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
    
    static boolean checkString(String s) {
        int n = s.length();
        
        int left = 0, right = n - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}

