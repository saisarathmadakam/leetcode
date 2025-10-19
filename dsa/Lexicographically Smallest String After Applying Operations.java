import java.util.*;

public class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.add(s);
        seen.add(s);
        String best = s;

        while (!q.isEmpty()) {
            String cur = q.poll();

            // keep smallest
            if (cur.compareTo(best) < 0) best = cur;

            // operation 1: add 'a' to all odd indices (0-based)
            char[] arr = cur.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int d = (arr[i] - '0' + a) % 10;
                arr[i] = (char)('0' + d);
            }
            String added = new String(arr);
            if (seen.add(added)) q.add(added);

        
            String rotated = cur.substring(n - b) + cur.substring(0, n - b);
            if (seen.add(rotated)) q.add(rotated);
        }

        return best;
    }
}
