import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (str == '(')queue.add(str);
            else {
                if (!queue.isEmpty() && queue.peek() == '(')queue.poll();
                else answer = false;
            }
        }

        return !queue.isEmpty() ? false : answer;
    }
}