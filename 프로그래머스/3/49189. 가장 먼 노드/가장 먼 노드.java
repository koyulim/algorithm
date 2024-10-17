import java.util.*;

class Solution {
    
    static class Node {
        int n;
        List<Node> edges;
        int cnt;
        boolean visit;
        
        Node (int n) {
            this.n = n;
            edges = new ArrayList<>();
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Node[] nodes = new Node[n + 1];
        
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            
            nodes[x].edges.add(nodes[y]);
            nodes[y].edges.add(nodes[x]);
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[1]);
        nodes[1].visit = true;
        nodes[1].cnt = 1;
        
        int max = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node val : node.edges) {
                if (!val.visit) {
                    val.cnt = node.cnt + 1;
                    val.visit = true;
                    queue.add(val);
                    max = node.cnt + 1;
                }
            }
        }
        
        
        for (int i = 0; i < nodes.length; i++) {
            if (max == nodes[i].cnt) answer++;
        }
        
        return answer;
    }
}