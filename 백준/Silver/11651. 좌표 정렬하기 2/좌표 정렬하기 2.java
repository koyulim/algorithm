import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];

        for (int i = 0; i < n; i ++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                list[i][j] = Integer.parseInt(input[j]);
            }
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare (int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        for (int i = 0; i < n; i++) {
            bw.write(list[i][0] + " " + list[i][1] + "\n");
        }

        bw.flush();
    }
}
