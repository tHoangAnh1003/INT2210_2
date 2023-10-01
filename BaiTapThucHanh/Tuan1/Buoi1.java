package BaiTapThucHanh.Tuan1;

import java.util.Scanner;

public class Buoi1 {
    public static final int maxN = 1001;
    
    public static int truongNhom[] = new int[maxN];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int u = in.nextInt(), v = in.nextInt();
        
        for (int i = 1; i <= u; ++i) {
            truongNhom[i] = i;
        }

        int answer = u;

        for (int i = 0; i < v; ++i) {
            int x = in.nextInt(), y = in.nextInt();
            if (truongNhom[x] != truongNhom[y]) {
                int truongNhomY = truongNhom[y];
                for (int j = 1; j <= u; ++j) {
                    if (truongNhom[j] == truongNhomY) truongNhom[j] = truongNhom[x];
                }
                answer -= 1;
            }
        }

        System.out.println(answer);

        in.close();
    }
}
