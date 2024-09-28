import java.util.*;
import java.io.*;
import java.awt.Point;
import java.awt.GraphicsDevice.WindowTranslucency;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
  

        Node[] nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

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
        System.out.println(cnt);
    }
}
