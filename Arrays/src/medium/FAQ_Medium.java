package medium;

import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.List;

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

    public static List<Integer> printMxNMatrixInSpiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while(top <= bottom && left <= right) {
            for(int i=left; i<=right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                for(int i=right; i>=left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right) {
                for(int i=bottom; i>=top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }

    public static int pascalTriangleI(int r, int c) {
        long res = 1;
        r--; c--;

        int iter = Math.min(c, r - c);
        for(int i=0; i<iter; i++) {
            res = res * (r - i);
            res = res / (i + 1);
        }

        return (int) res;
    }

    public static int[] pascalTriangleII(int r) {
        int[] res = new int[r];
        res[0] = 1;

        for(int i=1; i<r; i++) {
            res[i] = res[i - 1] * (r - i) / i;
        }

        return res;
    }

    public static  List<Integer> pascalTriangleIIList(int r) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);

        for(int i=1; i<r; i++) {
            res.add(res.get(i - 1) * (r - i) / i);
        }

        return res;
    }

    public static List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            ans.add(pascalTriangleIIList(i));
        }

        return ans;
    }

    public static void rotateMatrixBy90(int[][] matrix) {
        // Brute : Here is to create another nxn matrix traverse through the whole array and put the elements in the right place.
        // Optimal : Transpose the matrix and then reverse every row.
        int n = matrix.length;

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = -1, end = -1;
        int[][] sortedArr = new int[nums.length][2];

        for(int i=0; i<nums.length; i++) {
            int[] temp = new int[2];
            temp[0] = nums[i];
            temp[1] = i;
            sortedArr[i] = temp;
        }

        Arrays.sort(sortedArr, (int[] n1, int[] n2) -> Integer.compare(n1[0], n2[0]));

        while(left < right) {
            int valueLeft = sortedArr[left][0];
            int valueRight = sortedArr[right][0];
            if(valueLeft + valueRight == target) {
                start = sortedArr[left][1];
                end = sortedArr[right][1];
                break;
            } else if(valueLeft + valueRight > target) {
                right--;
            } else {
                left++;
            }
        }

        int[] ans = new int[2];
        ans[0] = start; ans[1] = end;

        return ans;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
