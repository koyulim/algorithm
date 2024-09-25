import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] card_list = br.readLine().split(" ");
        int[] list = new int[n];
        
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(card_list[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int z = j + 1; z < n; z++) {
                    if ((list[i] + list[j] + list[z]) <= m) {
                        arr.add((list[i] + list[j] + list[z]));
                    }
                }
            }
        }

        Collections.sort(arr, Collections.reverseOrder());
        bw.write(arr.get(0) + "\n");
        bw.flush();
    }
}