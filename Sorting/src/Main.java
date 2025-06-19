import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {13, 46, 24, 52, 20, 46, 9};
        int[] nums = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        int n = nums.length;
/*
        System.out.print(Arrays.toString(selection_sort(nums, n)));
        System.out.print(Arrays.toString(bubble_sort(nums, n)));
        System.out.print(Arrays.toString(insertion_sort(nums, n)));
        System.out.print(Arrays.toString(quick_sort(nums, n)));
*/
        System.out.print(Arrays.toString(merge_sort(nums, n)));
    }

    public static int[] selection_sort(int[] numbers, int n) {
        for(int i=0; i<n-1; i++) {
            int minIdx = i;
            for(int j=i+1; j<n; j++) {
                if(numbers[j] < numbers[minIdx]) {
                    minIdx = j;
                }
            }
            swap(numbers, i, minIdx);
        }
        return numbers;
    }

    public static int[] bubble_sort(int[] nums, int n) {
        for(int i=0; i<n-1; i++) {
            boolean isSwapped = false;
            for(int j=0; j<n-i-1; j++) {
                if(nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                    isSwapped = true;
                }
            }

            if(!isSwapped)
                break;
        }
        return nums;
    }

    public static int[] insertion_sort(int[] nums, int n) {
        for(int i=1; i<n; i++) {
            for(int j=i; j>0; j--) {
                if(nums[j] < nums[j-1])
                    swap(nums, j, j-1);
            }
        }

        return nums;
    }

    public static int[] quick_sort(int[] nums, int n) {
        qs(nums, 0, n-1);
        return nums;
    }
    public static void qs(int[] nums, int lo, int hi) {
        if(lo < hi) {
            int partIdx = qs_partition(nums, lo, hi);
            qs(nums, lo, partIdx - 1);
            qs(nums, partIdx + 1, hi);
        }
    }
    public static int qs_partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo, j = hi;
        while(i <= j) {
            while(i <= hi && nums[i] <= pivot) {
                i++;
            }

            while(j >= lo && nums[j] > pivot) {
                j--;
            }

            if(i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, lo, j);
        return j;
    }

    public static int[] merge_sort(int[] nums, int n) {
        ms(nums, 0, n - 1);
        return nums;
    }
    public static void ms(int[] nums, int lo, int hi) {
        if(lo >= hi) return;

        int mid = lo + (hi - lo) / 2;
        ms(nums, lo, mid);
        ms(nums, mid + 1, hi);
        mergeTwoSortedArrays(nums, lo, mid, hi);
    }
    public static void mergeTwoSortedArrays(int[] nums, int lo, int mid, int hi) {
        int left = lo, right = mid + 1;
        int[] tempArr = new int[hi - lo + 1];
        int idx = 0;
        while(left <= mid && right <= hi) {
            if(nums[left] < nums[right]) {
                tempArr[idx] = nums[left];
                left++;
            } else {
                tempArr[idx] = nums[right];
                right++;
            }
            idx++;
        }
        while(left <= mid) {
            tempArr[idx] = nums[left];
            left++; idx++;
        }
        while(right <= hi) {
            tempArr[idx] = nums[right];
            right++; idx++;
        }

        idx = 0;
        for(int i=lo; i<=hi; i++) {
            nums[i] = tempArr[idx];
            idx++;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}