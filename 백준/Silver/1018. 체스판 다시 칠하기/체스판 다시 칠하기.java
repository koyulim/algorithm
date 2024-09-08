import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        char[][] bord = new char[n][m];
        List<Integer> cntArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j ++) {
                bord[i][j] = str.charAt(j);
            }
        }

        int row = 0;
        int col = 0; 
        while (col + 8 <= n && row + 8 <= m) {
            int cntB = 0;
            int cntW = 0;
            for (int i = col; i < col + 8; i++) {
                for (int j = row; j < row + 8; j++) {
                    if ((j + i) % 2 == 0) {
                        if (bord[i][j] != 'B')cntB++;
                        if (bord[i][j] != 'W')cntW++;
                    } else {
                        if (bord[i][j] != 'B')cntW++;
                        if (bord[i][j] != 'W')cntB++;
                    }
                }
            }

            if (row + 8 == m) {
                col++;
                row = 0;
            } else {
                row++;
            }

            cntArr.add(cntB);
            cntArr.add(cntW);
        }

        Collections.sort(cntArr);
        bw.write(cntArr.get(0) + "\n");
        bw.flush();
    }
}