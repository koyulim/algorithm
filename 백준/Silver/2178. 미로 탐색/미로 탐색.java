import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] list = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int[][] result = new int[n][m];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                list[i][j] = input.charAt(j);
            }
        }

        int[] nx = {0, 0, 1, -1};
        int[] ny = {1, -1, 0, 0};

        result[0][0] = 1;
        queue.add(new Point(0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int rx = x + nx[i];
                int ry = y + ny[i];
                if (rx < n && ry < m && rx >= 0 && ry >= 0 && visit[rx][ry] == false && list[rx][ry] == '1') {
                    result[rx][ry] = result[x][y] + 1;
                    queue.add(new Point(rx, ry));
                    visit[rx][ry] = true;
                }
            }
        }

        bw.write(result[n - 1][m - 1] + "\n");
        bw.flush();
    }
}
