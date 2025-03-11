import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static int[][] list;
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] copyList;
    static List<Point> virus;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        list = new int[n][m];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                list[i][j] = Integer.parseInt(input[j]);
                if (list[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        backTraking(0);

        bw.write(result + "\n");
        bw.flush();
    }

    private static void backTraking(int depth) {
        if (depth == 3) {
            result = Math.max(result, bfs());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == 0) {
                    list[i][j] = 1;
                    backTraking(depth + 1);
                    list[i][j] = 0;
                }
            }
        }
 
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        copyList = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyList[i] = list[i].clone();
        }

        for (int i = 0; i < virus.size(); i++) {
            Point point = virus.get(i);
            queue.add(new Point(point.x, point.y));
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int z = 0; z < 4; z++) {
                int nx = dx[z] + x;
                int ny = dy[z] + y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && copyList[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    copyList[nx][ny] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyList[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
