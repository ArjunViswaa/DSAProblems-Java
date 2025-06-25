package fundamentals;

public class Linear_Search {
    public static int linearSearch(int nums[], int target) {
        //Your code goes here
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static int largestElement(int nums[], int n) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(nums[i] > largest) {
                largest = nums[i];
            }
        }
        return largest;
    }

    public static int secondLargest(int nums[], int n) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            }
            else if(nums[i] > secondLargest && nums[i] != largest)
                secondLargest = nums[i];
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
