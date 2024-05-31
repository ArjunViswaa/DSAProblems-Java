package Sorting;

import java.util.*;

public class Comparator2 {
	public static void solve(ArrayList<Integer> A) {
		int count = 0;
        for(int j=0; j<A.size(); j++) {
            count += A.get(j);
        }
        if(count == 0) {
            System.out.print("0");
        }
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                String V12 = String.valueOf(v1) + v2;
                String V21 = String.valueOf(v2) + v1;
                return V12.compareTo(V21) > 0 ? -1 : 1;
            }
        });
        String str = new String();
        for(int i=0; i<A.size(); i++) {
            str += A.get(i);
        }
        System.out.print(str);
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	arr.add(6);
    	arr.add(2318);
    	arr.add(9);
    	arr.add(23);
    	arr.add(423);
    	arr.add(790);
    	solve(arr);
    }
}
