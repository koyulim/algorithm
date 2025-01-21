import java.io.*;
import java.util.*;

public class Main {
    
    static int cnt;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        cnt = 0;

        backTraking(n, 0);
        bw.write(cnt + "\n");
        bw.flush();
    }

    public static void backTraking(int n, int r) {
        if (r == n) {
            cnt++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (chack(r, c)) {
                list[r] = c;
                backTraking(n, r + 1);
            }
        }
    }

    public static boolean chack(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (list[i] == c || Math.abs(list[i] - c) == Math.abs(i - r)) {
                return false;
            }
        }
        
        return true;
    }
}
