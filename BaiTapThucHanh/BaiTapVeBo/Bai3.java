package BaiTapThucHanh.BaiTapVeBo;

import java.util.*;

class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}



public class Bai3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;

        PriorityQueue<Pair<Integer, Integer>> minQueue = new PriorityQueue<>((pair1, pair2) -> pair1.getFirst().compareTo(pair2.getFirst()));


        for (int i = 1; i <= n; ++i) {
            int u = sc.nextInt(), v = sc.nextInt();

            if (i == n) {
                m = v;
                break;
            }

            if (u == 1) {
                minQueue.offer(new Pair<>(v, i));
            }
            else {
                if (!minQueue.isEmpty()) {
                    while (minQueue.size() >= v && !minQueue.isEmpty()) {
                        minQueue.poll();
                    }
                }
            }
        }

        if (m > minQueue.size()) {
            System.out.println(-1);
        }
        else {
            long maxSum = 0;
            ArrayList<Integer> ans = new ArrayList<>();

            while (!minQueue.isEmpty()) {
                Pair<Integer, Integer> x = minQueue.poll();
                maxSum += 1L * x.getFirst();
                ans.add(x.getSecond());
            }

            Collections.sort(ans);

            System.out.println(maxSum);
            for (int x : ans) {
                System.out.print(x + " ");
            }
        }


        sc.close();
    }
}
