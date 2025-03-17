import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static int[][] list;
    private static int[] temp;
    private static boolean[] visit;
    private static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        list = new int[n][n];
        m = n / 2;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        temp = new int[m];
        visit = new boolean[n];
        min = Integer.MAX_VALUE;
        backTracking(0, 0);
        System.out.println(min);
    }

    private static void backTracking(int depth, int start){
        if (depth == m) {
            int startTeam = 0;
            int linkTeam = 0;
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    int x = temp[i];
                    int y = temp[j];
                    startTeam += list[x][y] + list[y][x];
                }
            }

            List<Integer> link = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    link.add(i);
                }
            }

            for (int i = 0; i < link.size(); i++) {
                for (int j = i + 1; j < link.size(); j++) {
                    int x = link.get(i);
                    int y = link.get(j);
                    linkTeam += list[x][y] + list[y][x];
                }
            }
            
            min = Math.min(min, Math.abs(startTeam - linkTeam));
            return;
        }

        for (int i = start; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            temp[depth] = i;
            backTracking(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    
}