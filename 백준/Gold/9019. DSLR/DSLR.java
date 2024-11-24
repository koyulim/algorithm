import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int n;
        String comment;
        Node (int n, String comment) {
            this.n = n;
            this.comment = comment;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String result = "";
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            boolean[] visit = new boolean[10000];
            Queue<Node> queue = new LinkedList<>();
            
            queue.add(new Node(a, ""));
            visit[a] = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int n = node.n;
                String comment = node.comment;

                if (n == b) {
                    result = comment;
                    break;
                }

                int d = (n * 2) % 10000;
                if (!visit[d]) {
                    visit[d] = true;
                    queue.add(new Node(d, comment + "D"));
                }
                int s = (n == 0) ? 9999 : n - 1;
                if (!visit[s]) {
                    visit[s] = true;
                    queue.add(new Node(s, comment + "S"));
                }
                int l = (n % 1000) * 10 + (n / 1000);
                if (!visit[l]) {
                    visit[l] = true;
                    queue.add(new Node(l, comment + "L"));
                }
                int r = (n % 10) * 1000 + (n / 10);
                if (!visit[r]) {
                    visit[r] = true;
                    queue.add(new Node(r, comment + "R"));
                }
            }
            bw.write(result + "\n");
        }
    
        bw.flush();
    }
}
