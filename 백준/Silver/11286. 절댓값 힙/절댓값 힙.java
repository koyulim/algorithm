import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Queue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x == o2.x) return o1.y - o2.y;
                return o1.x - o2.x;
            }
        });
        
        for (int i = 0; i < size; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (!queue.isEmpty()) bw.write(queue.poll().y + "\n");
                else bw.write("0" + "\n");
            } else {
                queue.add(new Point(Math.abs(value), value));
            }
        }

        bw.write("\n");
        bw.flush();
    }
}
