package fundamentals;

public class Maximum_Consecutive_Ones {
    public static int maximumConsecutiveOnes(int[] nums, int n) {
        int count = 0, maxCount = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                count++;
                if(count > maxCount)
                    maxCount = count;
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}
