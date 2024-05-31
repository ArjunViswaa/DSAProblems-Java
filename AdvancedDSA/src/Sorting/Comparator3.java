package Sorting;

import java.util.*;

public class Comparator3 {
	public static void solve(ArrayList<ArrayList<Integer>> A, int B) {
		Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> A, ArrayList<Integer> B) {
                int dist1 = (A.get(0) * A.get(0)) + (A.get(1) * A.get(1));
                int dist2 = (B.get(0) * B.get(0)) + (B.get(1) * B.get(1));
                return dist1 - dist2;
            }
        });
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<B; i++) {
            ans.add(A.get(i));
        }
        System.out.print(ans);
    }
    
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    	arr.add(new ArrayList<>());
    	arr.get(0).add(1); arr.get(0).add(3);
    	arr.add(new ArrayList<>());
    	arr.get(1).add(-2); arr.get(1).add(2);
    	solve(arr, 2);
    }
}
