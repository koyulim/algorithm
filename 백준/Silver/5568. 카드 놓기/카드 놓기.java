import java.io.*;
import java.util.*;

public class Main {

    static int[] list;
    static int n;
    static int k;
    static boolean[] visit;
    static String[] temp;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        list = new int[n];
        temp = new String[k];
        for (int i = 0; i < n; i++) { 
            list[i] = Integer.parseInt(br.readLine());
        }

        backTraking(0);
        bw.write(set.size() + "\n");
        bw.close();
    }

    static void backTraking(int index) throws IOException {
        
        if (index == k) {
            String str = "";
            for (int i = 0; i < k; i++) {
                str += temp[i];
            }
            set.add(Integer.parseInt(str));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            temp[index] = String.valueOf(list[i]);
            backTraking(index + 1);
            visit[i] = false;
        }
    }
}
