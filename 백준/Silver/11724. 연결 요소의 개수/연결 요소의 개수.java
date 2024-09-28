import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static class Node {
        int n;
        List<Node> neighbor;
        boolean visit;

        Node(int n) {
            this.n = n;
            neighbor = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Node[] nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            nodes[a].neighbor.add(nodes[b]);
            nodes[b].neighbor.add(nodes[a]);
        }

        int cnt = 0;
        for (int j = 1; j <= n; j++) {
            if (!nodes[j].visit) {
                cnt++;
                Queue<Node> queue = new LinkedList<>();
                queue.add(nodes[j]);
                nodes[j].visit = true;
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (Node conect : node.neighbor) {
                        if (!conect.visit) {
                            queue.add(conect);
                            conect.visit = true;
                        }
                    }
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
