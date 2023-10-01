package HomeWork.Tuan4;

import java.util.*;

public class TongBang0 {

    public static final int maxN = 50;

	static int n;
	static int[] a = new int[maxN];
	static int[] b = new int[maxN];
	static boolean[] used = new boolean[maxN];
	static Set<List<Integer>> s = new HashSet<>();
    static int answer = 0, sum = 0;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        count(1);

        System.out.println(s.size());

        for (List<Integer> list : s) {
            System.out.println(list);
        }

        input.close();
    }

	static void count(int i) {
        for (int j = 0; j < n; ++j) {
            if (!used[j]) {
                used[j] = true;
                b[i] = a[j];
                sum += a[j];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int k = 1; k <= i; k++) {
                        tmp.add(b[k]);
                    }
                    tmp.sort(null);
                    s.add(tmp);
                } 
                else {
                    count(i + 1);
                }
                sum -= a[j];
                used[j] = false;
            }
        }
	}

}
