import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] list;
    static boolean[] visit;
    static int[] temp;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        m = n;
        list = new int[n];
        visit = new boolean[n];
        temp = new int[m];
        for (int i = 0; i < n; i++) {
            list[i] = i + 1;
        }

        backTraking(0);
        bw.flush();
    }

    public static void backTraking(int dept) throws IOException{
        if (dept == m) {
            for (int i = 0; i < temp.length; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            temp[dept] = list[i];
            backTraking(dept + 1);
            visit[i] = false;
        }
    }
}
