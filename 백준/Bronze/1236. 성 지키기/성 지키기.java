import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        char[][] list = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                list[i][j] = str.charAt(j);
            }
        }

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int rowCnt = 0;
        int colCnt = 0;
        for (int i = 0; i < n; i++) {
            if (!row[i]) {
                rowCnt++;
            }
        }

        for (int i = 0; i < m; i++) {
            if (!col[i]) {
                colCnt++;
            }
        }

        int total = 0;
        total = Math.max(rowCnt, colCnt);

        bw.write(total + "\n");
        bw.flush();
    }
}
