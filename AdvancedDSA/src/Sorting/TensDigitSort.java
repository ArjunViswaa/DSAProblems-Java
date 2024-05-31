package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TensDigitSort {
	
	public static void solve(ArrayList<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer A, Integer B) {
                if(tens(A) == tens(B)) {
                    return A - B;
                }
                return tens(A) - tens(B);
            }
        });
        System.out.print(A);
    }

    private static int tens(int A) {
        return ((A / 10) % 10);
    }
	
	public static void main(String[] args) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	arr.add(16);
    	arr.add(48);
    	arr.add(59);
    	arr.add(52);
    	arr.add(4);
    	arr.add(17);
    	solve(arr);
    }
}
