package medium;

import java.util.*;

public class LogicBuilding {
    public static void moveZeroesToTheEnd(int[] nums) {
        int j = -1, n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                j = i;
                break;
            }
        }

        if(j == -1) return;

        for(int i=j+1; i<n; i++) {
            if(nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    public static int removeDuplicatesFromSortedArray(int[] nums, int n) {
        int i = 0;

        for(int j=1; j<n; j++) {
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }

        return i + 1;
    }

    public static int findMissingNumber(int[] nums, int n) {
        // Brute force solution -> Linear search all nums from 1 to n and return missing number - O(N^2) / O(1)
        // Better solution -> Declare a hash array from 1 to N and initiate to 0, set flag to 1 when the
        //                    Specific number is found in the array iteration, again iterate through has array and
        //                    find the value with 0 and return -> O(N) / O(N)

        // Optimal solution 1 : Sum --- Sum of first n natural numbers = n * (n + 1) / 2
        /* int sum = 0;
        int actualSum = n * (n + 1) / 2;

        for(int i=0; i<n; i++) {
            sum += nums[i];
        }

        return actualSum - sum; */

        // Optimal solution 2 : XOR --- A ^ A = 0 ... (2 ^ 2) ^ (5 ^ 5) = 0 ^ 0 = 0 and 0 ^ A = A
        int xor = 0;

        for(int i=0; i<n; i++) {
            xor ^= nums[i];
        }
        for(int i=1; i<=n; i++) {
            xor ^= i;
        }

        return xor;
    }

    public static int[] unionOf2SortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;
        List<Integer> ans = new ArrayList<Integer>();

        while(i < n1 && j < n2) {
            if(nums1[i] <= nums2[j]) {
                if(ans.isEmpty() || nums1[i] != ans.getLast()) {
                    ans.add(nums1[i]);
                }
                i++;
            } else {
                if(ans.isEmpty() || nums2[j] != ans.getLast()) {
                    ans.add(nums2[j]);
                }
                j++;
            }
        }

        while(i < n1) {
            if(ans.isEmpty() || nums1[i] != ans.getLast()) {
                ans.add(nums1[i]);
            }
            i++;
        }

        while(j < n2) {
            if(ans.isEmpty() || nums2[j] != ans.getLast()) {
                ans.add(nums2[j]);
            }
            j++;
        }

        int[] unionArr = new int[ans.size()];
        for(int k=0; k<ans.size(); k++) {
            unionArr[k] = ans.get(k);
        }

        return unionArr;
    }

    public static int[] intersectionOf2SortedArrays(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] interArr = new int[res.size()];
        for(int k=0; k<res.size(); k++) {
            interArr[k] = res.get(k);
        }

        return interArr;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
