package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
	public static void wave(ArrayList<Integer> A) {
        Collections.sort(A);
        int i = 0;
        while(i < A.size() - 1) {
            int temp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, temp);
            i += 2;
        }
        System.out.print(A);
    }
	
	public static void main(String[] args) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	arr.add(6);
    	arr.add(8);
    	arr.add(9);
    	arr.add(2);
    	arr.add(4);
    	arr.add(7);
    	wave(arr);
    }
}
