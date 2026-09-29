package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Balanced Brackets (easy) - 2026-09-28
 * Given a string of ()[]{}, return true if every bracket is closed by the same type in the correct order.
 *
 * Approach: push openers on a stack; on a closer, the top of the stack must be its matching opener.
 * Time: O(n)   Space: O(n)   Time taken: 20 min
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        check("()[]{}", true);
        check("([{}])", true);
        check("(]", false);
        check("([)]", false);
        check("", true);
        check(")", false);   // closer on an empty stack
        check("((", false);  // unclosed openers
    }

    public static boolean balancedBrackets(String str) {
        Deque<Character> brackets = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char currBrack = str.charAt(i);
            if (currBrack == '(' || currBrack == '[' || currBrack == '{') {
                brackets.push(currBrack);
            } else {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (currBrack == ')' && brackets.peek() == '(') {
                    brackets.pop();
                } else if (currBrack == ']' && brackets.peek() == '[') {
                    brackets.pop();
                } else if (currBrack == '}' && brackets.peek() == '{') {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }

    private static void check(String input, boolean expected) {
        boolean actual = balancedBrackets(input);
        System.out.println((actual == expected ? "PASS  " : "FAIL  ") + "\"" + input + "\" -> " + actual);
    }
}
