import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int s;
    static int m;
    static int[] list;
    static int cnt;
    static boolean[] visit;
    static int[] temp;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        s = Integer.parseInt(nm[1]);
        list = new int[n];
        visit = new boolean[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]);
        }
        
        for (int i = 0; i < n; i++) {
            m = i + 1;
            temp = new int[m];
            backTraking(0, 0);
        }
        
        bw.write(cnt + "\n");
        bw.flush();
    }

    public static void backTraking(int dept, int start) throws IOException{
        if (dept == m) {
            int resut = 0;
            for (int i = 0; i < temp.length; i++) {
                resut += temp[i];
            }
            if (resut == s) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            temp[dept] = list[i];
            backTraking(dept + 1, i);
            visit[i] = false;
        }
    }
}
