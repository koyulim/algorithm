import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Point> location = new ArrayList<>();

            for (int j = 0; j < n + 2; j++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                location.add(new Point(x, y));
            }

            Queue<Point> queue = new LinkedList<>();
            boolean[] visit = new boolean[n + 2];
            queue.add(location.get(0));
            visit[0] = true;

            boolean chack = false;
            while (!queue.isEmpty()) {
                Point point = queue.poll();

                if (point.x == location.get(n + 1).x && point.y == location.get(n + 1).y) {
                    chack = true;
                    break;
                }

                for (int j = 0; j < n + 2; j++) {
                    if (!visit[j]) {
                        Point next = location.get(j);
                        int leng = Math.abs(point.x - next.x) + Math.abs(point.y - next.y);
                        if (leng <= 1000) {
                            queue.add(next);
                            visit[j] = true;
                        }
                    }
                }
            }
            
            if (chack) {
                bw.write("happy" + "\n");
            } else {
                bw.write("sad" + "\n");
            }
        }
        bw.flush();
    }
}
