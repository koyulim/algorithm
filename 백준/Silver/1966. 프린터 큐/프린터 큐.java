import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            Queue<Point> queue = new LinkedList<>();

            String[] input = br.readLine().split(" ");
            Integer[] list = new Integer[n];
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(input[j]);
                queue.add(new Point(val, j));
                list[j] = val;
            }
            
            Arrays.sort(list, Comparator.reverseOrder());

            for (int j = 0; j < n; j++) {
                int val = list[j];
                int result = 0;
                while (true) {
                    Point point = queue.poll();
                    if (val == point.x) {
                        result = point.y;
                        break;
                    } else {
                        queue.add(point);
                    }
                }
                
                if (result == m) {
                    bw.write((j + 1) + "\n");
                    break;
                }
            }
        }


        bw.flush();
    }
}
