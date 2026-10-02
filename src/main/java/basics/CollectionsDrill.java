package basics;

import java.util.*;

public class CollectionsDrill {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseArray(new int[]{1,2,3,4,5})));  // [5, 4, 3, 2, 1]
        System.out.println(removeEven(10));                                      // [1, 3, 5, 7, 9]
        System.out.println(firstCharWithoutRepeat("swiss"));                     // w
        System.out.println(duplicateElementInArray(new int[]{1,2,3,1}));         // true
        System.out.println(duplicateElementInArray(new int[]{1,2,3}));           // false
        System.out.println(isPallindrome("A man, a plan, a canal: Panama"));     // true
        System.out.println("[" + reverseSentence("the sky is blue") + "]");      // [blue is sky the]
        comparatorLogic(new ArrayList<>(List.of(3, -1, 7, 0)));
    }

    public static int[] reverseArray(int[] arr) {
        for(int i=0; i<arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }

    public static ArrayList<Integer> removeEven(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            arr.add(i);
        }
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) % 2 == 0) {
                arr.remove(i);
            }
        }

        return arr;
    }

    public static Character firstCharWithoutRepeat(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            hm.putIfAbsent(str.charAt(i), 0);
            hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
        }
        for(int i=0; i<str.length(); i++) {
            if(hm.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }

    public static boolean duplicateElementInArray(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int n: arr) {
            if(hs.contains(n)) {
                return true;
            }
            hs.add(n);
        }

        return false;
    }

    public static boolean isPallindrome(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", "");

        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static String reverseSentence(String str) {
        String[] words = str.split("\\s+");
        StringBuilder res = new StringBuilder();

        for(int i=words.length - 1; i > 0; i--) {
            res.append(words[i]);
            res.append(" ");
        }

        res.append(words[0]);

        return res.toString();
    }

    public static void comparatorLogic(ArrayList<Integer> arr) {
        arr.sort((a, b) -> Integer.compare(a, b));
        System.out.println("Ascending order - " + arr);
        arr.sort((a, b) -> Integer.compare(b, a));
        System.out.println("Descending order - " + arr);
    }
}
