import java.io.*;
import java.util.*;

public class Main {

    static int[] list;
    static int n;
    static int m;
    static int[] temp;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        list = new int[n];
        temp = new int[m];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(list);

        backTraking(0, 0);
        bw.close();
    }

    static void backTraking(int index, int dept) throws IOException {
        
        if (index == m) {
            for (int i = 0; i < m; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        for (int i = dept; i < n; i++) {
            temp[index] = list[i];
            backTraking(index + 1, i + 1);
        }
    }
}
