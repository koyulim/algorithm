import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] str = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                str[i][j] = input.charAt(j);
            }
        }

        boolean[][] visit;
        Queue<Point> queue = new LinkedList<>();

        int[] bx = {0, 0, 1, -1};
        int[] by = {1, -1, 0, 0};

        int cnt = 0;
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    cnt++;
                }

                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    int x = point.x;
                    int y = point.y;

                    for (int z = 0; z < 4; z++) {
                        int nx = x + bx[z];
                        int ny = y + by[z];
                        
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n && str[x][y] == str[nx][ny] && !visit[nx][ny]) {
                            queue.add(new Point(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
        }

        bw.write(cnt + "\n");
        
        visit = new boolean[n][n];
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    cnt2++;
                }

                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    int x = point.x;
                    int y = point.y;

                    for (int z = 0; z < 4; z++) {
                        int nx = x + bx[z];
                        int ny = y + by[z];
                        if (str[x][y] == 'R' || str[x][y] == 'G') {
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && str[nx][ny] != 'B' && !visit[nx][ny]) {
                                queue.add(new Point(nx, ny));
                                visit[nx][ny] = true;
                            }
                        } else {
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && str[x][y] == str[nx][ny] && !visit[nx][ny]) {
                                queue.add(new Point(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

        bw.write(cnt2 + "\n");
        bw.flush();
    }
}
