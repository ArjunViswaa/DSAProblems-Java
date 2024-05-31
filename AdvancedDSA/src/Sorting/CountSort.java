package Sorting;
import java.util.*;

public class CountSort {
	public static void main(String[] args) {
		Integer[] inp = {3,10,6,8,15,2,12,18,17};
		int min = Collections.min(Arrays.asList(inp)); // min = 2
		int max = Collections.max(Arrays.asList(inp)); // max = 18

		int[] freq = new int[max - min + 1]; 
		for(int x: inp) {
			freq[x - min]++;
		}
		// Actual nums: 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12, 13, 14, 15, 16, 17, 18
		// freq[17] =  [1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1,  0,  0,  1,  0,  1,  1]
		// indices  =   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
		for(int i=0; i<freq.length; i++) {
			while(freq[i] > 0) {
				System.out.print((i + min) + ".. ");
				freq[i]--;
			}
		}
	}
}
