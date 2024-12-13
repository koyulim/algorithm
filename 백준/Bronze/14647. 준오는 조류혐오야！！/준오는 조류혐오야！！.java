import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] list = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                String str = input[j];
                int cnt = 0;
                for (int z = 0; z < str.length(); z++) {
                    if (str.charAt(z) == '9') {
                        cnt++;
                    }
                }
                list[i][j] = cnt;
            }
        }

        int resultX = 0;
        int resultY = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < m; j++) {
                total += list[i][j]; 
            }
            if (resultX < total) {
                resultX = total;
                x = i;
            }
        }

        for (int i = 0; i < m; i++) {
            int total = 0;
            for (int j = 0; j < n; j++) {
                total += list[j][i];
            }
            if (resultY < total) {
                resultY = total;
                y = i;
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (resultX > resultY) {
                    if (i == x) {
                        continue;
                    } else {
                        result += list[i][j];
                    }
                } else if (resultX <= resultY) {
                    if (j == y) {
                        continue;
                    } else {
                        result += list[i][j];
                    }
                } 
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
