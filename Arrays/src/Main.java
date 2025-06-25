import fundamentals.*;
import medium.LogicBuilding;
import medium.FAQ_Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {13, 46, 24, 52, 20, 46, 9};
        int[] nums = {3, 1, 2, 4, 1, 5, 2, 6, 4, 9, 10, 2, 3};
        int[] sortedNums = {1, 1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7};
        int[] binarynums = {1, 1, 0, 0, 1, 1, 1, 0, 0};
        int[] posNnegNums = {2, 4, 5, -1, -3, -4};
        int n = nums.length;

        int targetIndex = fundamentals.Linear_Search.linearSearch(nums, 5);

        int largestElement = fundamentals.Linear_Search.largestElement(nums, n);

        int secondLargestElement = fundamentals.Linear_Search.secondLargest(nums, n);

        int maximumConsecutiveOnes = fundamentals.Maximum_Consecutive_Ones.maximumConsecutiveOnes(binarynums, binarynums.length);

//        int[] leftRotateByOne = fundamentals.Left_Rotate.leftRotateArrayByOne(nums, n);

//        int[] leftRotateByK = fundamentals.Left_Rotate.leftRotateArrayByK_Brute(nums, n, 4);
//        int[] leftRotateByK = fundamentals.Left_Rotate.leftRotateArrayByK_Optimal(nums, n, 4);

//        LogicBuilding.moveZeroesToTheEnd(binarynums);
//        int numberOfUniqueElements = LogicBuilding.removeDuplicatesFromSortedArray(sortedNums, sortedNums.length);

//        ArrayList<Integer> leadersInArray = FAQ_Medium.leadersInArray(nums);
        int[] rearrangeArrayElementsBySign = FAQ_Medium.rearrangeArrayElementsBySign(posNnegNums);
        System.out.println(Arrays.toString(rearrangeArrayElementsBySign));
//        System.out.println(leadersInArray);
    }
}