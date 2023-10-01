package BaiTapThucHanh.Tuan2;

import java.util.Scanner;

public class Buoi2 {
    
    public static final int maxN = 101;
	public static int[] root = new int[maxN];

	public static void khoiTaoMang() {
		for (int i = 0; i < maxN; ++i) {
			root[i] = -1;
		}
	}

	public static int getRoot(int x) {
		if (root[x] < 0) return x;
		return (root[x] = getRoot(root[x]));
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		khoiTaoMang();

		int ans = n;

		while (input.hasNext()) {
			int x = input.nextInt();
			int y = input.nextInt();

			x = getRoot(x);
			y = getRoot(y);

			if (x != y) {
				ans -= 1;
				if (root[x] > root[y]) {
					root[y] += root[x];
					root[x] = y;
				}
				else {
					root[x] += root[y];
					root[y] = x;
				}
			}

		}

		System.out.println(ans);

		input.close();
	}
}
