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

        int total = 0;
        int[] rowCounts = new int[n];
        int[] colCounts = new int[m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int count9 = 0;
                String cell = input[j];
                for (int z = 0; z < cell.length(); z++) {
                    if (cell.charAt(z) == '9') {
                        count9++;
                    }
                }
                rowCounts[i] += count9;
                colCounts[j] += count9;
                total += count9;
            }
        }

        int maxRow = 0;
        int maxCol = 0;
        for (int count : rowCounts) {
            maxRow = Math.max(maxRow, count);
        }
        for (int count : colCounts) {
            maxCol = Math.max(maxCol, count);
        }
        
        bw.write((total - Math.max(maxRow, maxCol)) + "\n");
        bw.flush();
    }
}
