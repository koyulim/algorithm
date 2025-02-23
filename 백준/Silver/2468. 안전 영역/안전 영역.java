import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

    private static int size;
    private static int[][] list;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        list = new int[size][size];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                list[i][j] = Integer.parseInt(input[j]);
                max = Math.max(max, Integer.parseInt(input[j]));
                min = Math.min(min, Integer.parseInt(input[j]));
            }
        }

        
        int result = 1;
        while (min < max) {
            int cnt = 0;
            boolean[][] visit = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (list[i][j] > min && !visit[i][j]) {
                        bfs(i, j, visit, min);
                        cnt++;
                    }
                }
            }
            min++;
            result = Math.max(result, cnt);
        }
        
        bw.write(result + "\n");
        bw.flush();
    }

    private static void bfs(int x, int y, boolean[][] visit, int hight) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int px = point.x;
            int py = point.y;

            for (int z = 0; z < 4; z++) {
                int nx = dx[z] + px;
                int ny = dy[z] + py;

                if (nx >= 0 && ny >= 0 && nx < size && ny < size && !visit[nx][ny] && list[nx][ny] > hight) {
                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
