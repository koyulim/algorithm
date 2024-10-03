import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] list = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        int goalX = 0;
        int goalY = 0;

        for (int i = 0; i < n; i++) {
            String[] mList = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(mList[j]) == 2) {
                    goalX = i;
                    goalY = j;
                }
                list[i][j] = Integer.parseInt(mList[j]);
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(goalX, goalY));
        list[goalX][goalY] = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && list[nx][ny] == 1 && !visit[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    list[nx][ny] = list[x][y] + 1;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == 1 && visit[i][j] == false)bw.write(-1 + " ");
                else bw.write(list[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
