import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = Integer.parseInt(br.readLine());
        for (int z = 0; z < size; z++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[][] list = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int cnt = 0;
            
            for (int i = 0; i < Integer.parseInt(input[2]); i++) {
                String[] idx = br.readLine().split(" ");
                int x = Integer.parseInt(idx[0]);
                int y = Integer.parseInt(idx[1]);
                list[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (list[i][j] == 1 && !visited[i][j]) {
                        Queue<Point> queue = new LinkedList<>();
                        queue.add(new Point(i, j));
                        visited[i][j] = true;
                        
                        while (!queue.isEmpty()) {
                            Point p = queue.poll();
                            int x = p.x;
                            int y = p.y;

                            if (y + 1 < m && list[x][y + 1] == 1 && !visited[x][y + 1]) {
                                visited[x][y + 1] = true;
                                queue.add(new Point(x, y + 1));
                            }
                            if (y > 0 && list[x][y - 1] == 1 && !visited[x][y - 1]) {
                                visited[x][y - 1] = true;
                                queue.add(new Point(x, y - 1));
                            }
                            if (x + 1 < n && list[x + 1][y] == 1 && !visited[x + 1][y]) {
                                visited[x + 1][y] = true;
                                queue.add(new Point(x + 1, y));
                            }
                            if (x > 0 && list[x - 1][y] == 1 && !visited[x - 1][y]) {
                                visited[x - 1][y] = true;
                                queue.add(new Point(x - 1, y));
                            }
                        }
                        cnt++;
                    }
                }
            }
            bw.write(cnt + "\n");
        }
    
        bw.flush();
    }
}
