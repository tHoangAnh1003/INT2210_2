package BaiTapThucHanh.Tuan3;

import java.util.*;

public class ThreeSum {

    public static final int maxN = 1001;

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> luuTru = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    luuTru.add(temp);
                    ++j;
                    --k;
                }
                else if (sum < 0) {
                    ++j;
                }
                else { --k; }
            }
        }
        for (List<Integer> x : luuTru) {
            answer.add(x);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[maxN];

        for (int i = 0; i < n; ++i) {
            nums[i] = input.nextInt();
        }

        System.out.println(threeSum(nums));

        input.close();
    }
}
