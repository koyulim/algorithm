import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int node;
        List<Node> edges;
        Node (int node) {
            this.node = node;
            edges = new ArrayList<>();
        }
    }

    private static boolean[] visit;
    private static boolean flag;
    private static int n, m;
    private static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        flag = false;
        visit = new boolean[n];
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
        
            nodes[start].edges.add(nodes[end]);
            nodes[end].edges.add(nodes[start]);
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visit, false);
            visit[i] = true;
            dfs(1, i);
        }
        if (flag) bw.write("1" + "\n");
        else bw.write("0" + "\n");
        bw.flush();
    }

    private static void dfs(int depth, int node) {
        
        if (flag) return;
        if (depth == 5) {
            flag = true;
            return;
        }

        for (Node value : nodes[node].edges) {
            if (visit[value.node]) continue;
            visit[value.node] = true;
            dfs(depth + 1, value.node);
            visit[value.node] = false;
        }
    }
}
