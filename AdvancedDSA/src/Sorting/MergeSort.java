package Sorting;
import java.util.*;

public class MergeSort {
	public static void main(String args[]) {
		int[] inp = new int[]{3,10,6,8,15,2,12,18,17};
//		int[] inp = acceptArrayElements();
		mergeSort(inp, 0, inp.length - 1);
		System.out.println("Merge Sorted Array :- ");
		for(int x: inp) {
			System.out.print(x + ".. ");
		}
	}
	
	private static void mergeSort(int[] A, int l, int r) {
		if(l == r) {
			return;
		}
		int mid = (l + r) / 2;
		mergeSort(A, l, mid);
		mergeSort(A, mid + 1, r);
		merge(A, l, mid, r);
		return;
	}
	
	private static void merge(int[] A, int l, int mid, int r) {
		int N1 = mid - l + 1;
		int N2 = r - mid;
		int[] B = new int[N1]; int[] C = new int[N2];
		B = Arrays.copyOfRange(A, l, mid + 1);
		C = Arrays.copyOfRange(A, mid + 1, r + 1);
		int idx = l, i = 0, j = 0;
		while(i < N1 && j < N2) {
			if(B[i] < C[j]) {
				A[idx] = B[i];
				i++;
			} else {
				A[idx] = C[j];
				j++;
			}
			idx++;
		}
		while(i < N1) {
			A[idx] = B[i];
			i++; idx++;
		}
		while(j < N2) {
			A[idx] = C[j];
			j++; idx++;
		}
	}
	
//	private static int[] acceptArrayElements() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the size of the array: ");
//        int arr_size = 0;
//        if (sc.hasNextInt()) {
//            arr_size = sc.nextInt();
//        }
//        int[] arr = new int[arr_size];
//        System.out.println("Enter the elements of the array: ");
//        for (int i = 0; i < arr_size; i++) {
//            if (sc.hasNextInt()) {
//                arr[i] = sc.nextInt();
//            }
//        }
//        sc.close();
//        return arr;
//	}
}
