package HomeWork.Tuan5;

import java.util.*;
import Stack.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; ++i) {
            String s = input.nextLine();

            boolean answer = check(s);

            if (answer) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

        input.close();
    }

    static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                st.push(c);
            }
            else {
                if (st.isEmpty()) { return false; }
                
                char x = st.peek();
                st.pop();
                if ((x == '{' && c != '}') || (x == '[' && c != ']') || (x == '(' && c != ')')) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

}