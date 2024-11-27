import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        long n;
        List<Node> edges;
        Node (long n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);

            int b = d / (k * m * (m - 1) + m * m);
            int result = (k * m * (m - 1) + m * m) * b; 

            if (result == 0) bw.write("-1" + "\n");
            else bw.write(result + "\n");
            
        }
        
        bw.flush();
    }
}
