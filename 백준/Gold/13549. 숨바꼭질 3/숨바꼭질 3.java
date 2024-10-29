import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        if (n == k) {
            bw.write(0 + "\n");
            bw.flush();
            return;
        }

        int max = 100000;
        int[] mdt = new int[max + 1];
        Arrays.fill(mdt, Integer.MAX_VALUE);
        mdt[n] = 0;

        Queue<Point> queue = new PriorityQueue<>(Comparator.comparing(e -> e.y));
        queue.add(new Point(n, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            if (y > mdt[x]) continue;
            
            if ((x - 1) >= 0) {
                int nextY = y + 1;
                if (mdt[x - 1] > nextY) {
                    mdt[x - 1] = nextY;
                    queue.add(new Point(x - 1, nextY));
                }
            }

            if ((x + 1) <= max) {
                int nextY = y + 1;
                if (mdt[x + 1] > nextY) {
                    mdt[x + 1] = nextY;
                    queue.add(new Point(x + 1, nextY));
                }
            }

            if ((x * 2) <= max) {
                int nextY = y;
                if (mdt[x * 2] > nextY) {
                    mdt[x * 2] = nextY;
                    queue.add(new Point(x * 2, nextY));
                }
            }
        }

        bw.write(mdt[k] + "\n");
        bw.flush();
    }
}
