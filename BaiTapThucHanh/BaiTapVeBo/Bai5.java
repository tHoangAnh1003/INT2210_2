package BaiTapThucHanh.BaiTapVeBo;

import java.util.*;

public class Bai5 {

    public static final int maxN = 300001;
    public static int[] t = new int[4 * maxN];
    public static int[] a = new int[maxN];

    public static void build(int v, int left, int right) {
        if (left == right) {
            t[v] = a[left];
        } else {
            int mid = (left + right) / 2;
            
            build(2 * v, left, mid);
            build(2 * v + 1, mid + 1, right);

            t[v] = Math.min(t[2 * v], t[2 * v + 1]);
        }
    }

    public static int query(int v, int left, int right, int l, int r) {
        if (r < left || right < l) {
            return Integer.MAX_VALUE;
        }

        if (l <= left && right <= r) {
            return t[v];
        }

        int mid = (left + right) / 2;

        return Math.min(query(2 * v, left, mid, l, r), query(2 * v + 1, mid + 1, right, l, r));
    }

    public static void update(int v, int left, int right, int pos, int val) {
        if (left == right) {
            t[v] = val;
        }
        else {
            int mid = (left + right) / 2;
            if (pos <= mid) {
                update(2 * v, left, mid, pos, val);
            }
            else {
                update(2 * v + 1, mid + 1, right, pos, val);
            }
            t[v] = Math.min(t[2 * v], t[2 * v + 1]);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }

        build(1, 0, n - 1);

        int m = sc.nextInt();

        for (int i = 0; i < m; ++i) {
            int t = sc.nextInt();

            switch(t) {
                case 1: {
                    int l = sc.nextInt(), r = sc.nextInt();
                    System.out.println(query(1, 0, n - 1, l - 1, r - 1));
                    break;
                }
                case 2: {
                    int pos = sc.nextInt(), val = sc.nextInt();
                    update(1, 0, n - 1, pos - 1, val);
                    break;
                }
            }
        }

        sc.close();
    }
}