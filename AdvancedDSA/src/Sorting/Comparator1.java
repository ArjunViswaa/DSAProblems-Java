package Sorting;

import java.util.*;

public class Comparator1 {
	public static void solve(ArrayList<Integer> A) {
        Comparator<Integer> factsCompare = new Comparator<Integer>() {
            @Override
            public int compare(Integer A, Integer B) {
                if(facts(A) == facts(B)) {
                    return A - B;
                } else {
                    return facts(A) - facts(B);
                }
            }
        };
        Collections.sort(A, factsCompare);
        System.out.print(A);
    }

    private static int facts(int A) {
        int count = 0;
        for(int i=1; i <= A/2; i++) {
            if(A % i == 0) {
                if(i * i == A) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	arr.add(6);
    	arr.add(8);
    	arr.add(9);
    	arr.add(2);
    	arr.add(4);
    	arr.add(7);
    	solve(arr);
    }
}
