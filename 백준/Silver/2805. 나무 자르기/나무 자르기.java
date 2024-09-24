import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int leng = Integer.parseInt(input[1]);

        String[] treeS = br.readLine().split(" ");
        Integer[] tree = new Integer[size];
        for (int i = 0; i < size; i++) {
            tree[i] = Integer.parseInt(treeS[i]);
        }

        Arrays.sort(tree, Collections.reverseOrder());

        int low = 0;
        int high = tree[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;

            for (int val : tree) {
                if (val > mid) {
                    total += val - mid;
                }
            }

            if (total >= leng) {
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        

        bw.write(high + "\n");

        
        bw.flush();
    }
}