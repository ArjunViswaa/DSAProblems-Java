package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge Intervals (medium) - 2026-09-28
 * Merge all overlapping intervals (touching counts as overlapping) and return the result.
 *
 * Approach: sort by start. Walk the list; if the previous interval's end >= current start,
 * fold the previous into the current. Otherwise the previous interval is final, so add it.
 * Time: O(n log n) for the sort   Space: O(n) for the result   Time taken: 40 min, 2 hints
 *
 * Review notes: Math.min on the start is not needed after sorting; the input array is modified;
 * Integer.compare avoids overflow in the comparator.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        check(new int[][]{{1,3},{2,6},{8,10},{15,18}}, new int[][]{{1,6},{8,10},{15,18}});
        check(new int[][]{{1,4},{4,5}},                new int[][]{{1,5}});          // touching
        check(new int[][]{{1,4},{0,2}},                new int[][]{{0,4}});          // unsorted
        check(new int[][]{{1,10},{2,3}},               new int[][]{{1,10}});         // contained
        check(new int[][]{{5,6},{1,2}},                new int[][]{{1,2},{5,6}});    // no overlap, unsorted
        check(new int[][]{{1,3},{2,6},{5,8},{10,12}},  new int[][]{{1,8},{10,12}});  // chain merge
        check(new int[][]{{7,9}},                      new int[][]{{7,9}});          // single
        check(new int[][]{},                           new int[][]{});               // empty
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            } else {
                result.add(intervals[i - 1]);
            }
        }

        if (intervals.length > 0)
            result.add(intervals[intervals.length - 1]);

        return result.toArray(new int[0][]);
    }

    private static void check(int[][] input, int[][] expected) {
        String in = Arrays.deepToString(input);
        int[][] actual = merge(input);
        boolean ok = Arrays.deepEquals(actual, expected);
        System.out.println((ok ? "PASS  " : "FAIL  ") + in
                + " -> " + Arrays.deepToString(actual)
                + (ok ? "" : "   expected " + Arrays.deepToString(expected)));
    }
}
