import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = br.readLine().split(" ");
        int m = Integer.parseInt(size[0]);
        int n = Integer.parseInt(size[1]);

        int[][] list = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(input[j]);
                if (val == 1) {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                }
                list[i][j] = val;
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            if (y + 1 < m) {
                if (list[x][y + 1] == 0 && visit[x][y + 1] == false) {
                    queue.add(new Point(x, y + 1));
                    visit[x][y + 1] = true;
                    list[x][y + 1] = list[x][y] + 1;
                }
            }
            if (y > 0) {
                if (list[x][y - 1] == 0 && visit[x][y - 1] == false) {
                    queue.add(new Point(x, y - 1));
                    visit[x][y - 1] = true;
                    list[x][y - 1] = list[x][y] + 1;

                }
            }
            if (x + 1 < n) {
                if (list[x + 1][y] == 0 && visit[x + 1][y] == false) {
                    queue.add(new Point(x + 1, y));
                    visit[x + 1][y] = true;
                    list[x + 1][y] = list[x][y] + 1;

                }
            }
            if (x > 0) {
                if (list[x - 1][y] == 0 && visit[x - 1][y] == false) {
                    queue.add(new Point(x - 1, y));
                    visit[x - 1][y] = true;
                    list[x - 1][y] = list[x][y] + 1;

                }
            }
        }

        int result = 0;
        boolean check = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == 0) {
                    check = true;
                    break;
                } else {
                    result = Math.max(result, list[i][j]);
                }                
            }
            if (check) {
                break;
            }
        }

        if (check) {
            result = -1;
        } else {
            result = result - 1;
        }
        
        bw.write(result + "\n");
        bw.flush();
    }

}
