package HomeWork.Tuan2;

import java.util.Scanner;

public class UFCilent2 {
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
		int count = 0;
		boolean flag = false;

		while (input.hasNext()) {
			int x = input.nextInt();
			int y = input.nextInt();

			x = getRoot(x);
			y = getRoot(y);
			count += 1;

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

			if (ans == 1) {
				flag = true;
				break;
			}

		}

		if (flag) {
			System.out.println(count);
		}
		else {
			System.out.println("Fail");
		}

		input.close();
	}
}
