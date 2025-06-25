package fundamentals;

public class Left_Rotate {
    public static int[] leftRotateArrayByOne(int[] nums, int n) {
        int firstVal = nums[0];

        for(int i=1; i<n; i++) {
            nums[i - 1] = nums[i];
        }
        nums[n - 1] = firstVal;

        return nums;
    }

    public static int[] leftRotateArrayByK_Brute(int[] nums, int n, int k) {
        int[] temp = new int[k];
        k = k % n;

        for(int i=0; i<k; i++) {
            temp[i] = nums[i];
        }
        for(int i=k; i<n; i++) {
            nums[i - k] = nums[i];
        }// k = 3, n = 7
        for(int i=n-k; i<n; i++) {
            nums[i] = temp[i - (n - k)];
        }

        return nums;
    }

    public static int[] leftRotateArrayByK_Optimal(int[] nums, int n, int k) {
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, n - 1);
        reverseArr(nums, 0, n-1);

        return nums;
    }

    private static void reverseArr(int[] nums, int first, int last) {
        int i = first, j = last;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}
