package medium;

import java.util.ArrayList;
import java.util.Collections;

public class FAQ_Medium {
    public static ArrayList<Integer> leadersInArray(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int largestTillNow = Integer.MIN_VALUE;

        for(int i=nums.length - 1; i>=0; i--) {
            if(nums[i] > largestTillNow) {
                largestTillNow = nums[i];
                ans.add(nums[i]);
            }
        }
        Collections.reverse(ans);

        return ans;
    }

    public static int[] rearrangeArrayElementsBySign(int[] nums) {
        int pos = 0, neg = 1, idx = 0;
        int[] ans = new int[nums.length];

        while(idx < nums.length) {
            if(nums[idx] > 0) {
                ans[pos] = nums[idx];
                pos += 2;
            } else {
                ans[neg] = nums[idx];
                neg += 2;
            }
            idx++;
        }

        return ans;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
