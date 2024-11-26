import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][][] shapes = {

            // ㅡ
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            
            // ㅁ
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},

            // L
            {{0, 0}, {1, 0}, {1,  1},  {1,  2}},
            {{0, 0}, {0, 1}, {0,  2},  {-1, 2}},
            {{0, 0}, {1, 0}, {0,  1},  {0,  2}},
            {{0, 0}, {0, 1}, {0,  2},  {1,  2}},
            {{0, 0}, {1, 0}, {2,  0},  {2,  1}},
            {{0, 0}, {1, 0}, {2,  0},  {2,  -1}},
            {{0, 0}, {1, 0}, {2,  0},  {0,  1}},
            {{0, 0}, {1, 0}, {2,  0},  {0,  -1}},

            // T
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 0}},
            {{0, 0}, {1, 0}, {1, -1}, {2, 0}}, 
            
            // Z
            {{0, 0}, {1, 0}, {1,  1},  {2,  1}},
            {{0, 0}, {1, 0}, {1,  -1}, {2,  -1}},
            {{0, 0}, {0, 1}, {-1, 1},  {-1, 2}},
            {{0, 0}, {0, 1}, {1,  1},  {1,  2}},

        };

        int[][] list = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[][] tetro : shapes) {
                    int sum = 0;
                    boolean chack = true;
                    for (int[] block : tetro) {
                        int nx = i + block[0];
                        int ny = j + block[1];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            chack = false;
                            break;
                        }
                        sum += list[nx][ny];
                    }
                    if (chack) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
