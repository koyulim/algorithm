import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[][] list = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[i][0] = start;
            list[i][1] = end;
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        
        Stack<Point> stack = new Stack<>(); 
        stack.add(new Point(list[0][0], list[0][1]));

        for (int i = 1; i < n; i++) {
            Point p = stack.peek();
            int x = p.x;
            int y = p.y;

            if (y <= list[i][0]) {
                stack.add(new Point(list[i][0], list[i][1]));
            } else if (x <= list[i][0] && y >= list[i][1]) {
                stack.pop();
                stack.add(new Point(list[i][0], list[i][1]));
            }
        }

        bw.write(stack.size() + "\n");
        bw.flush();
    }
}
