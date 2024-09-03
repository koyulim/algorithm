import java.awt.Point;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < priorities.length; i++)queue.add(new Point(priorities[i], i));
        Arrays.sort(priorities);
        int index = priorities.length - 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            int num = priorities[index];
            if (x < num)queue.add(new Point(x, y));
            else {
                answer++;  
                if (y == location)return answer;
                index--;
            }
        }
        return answer;
    }
}