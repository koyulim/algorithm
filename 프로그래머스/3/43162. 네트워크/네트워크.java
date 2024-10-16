import java.util.*;

class Solution {
    
    static class Node{
        int n;
        List<Node> edge;
        boolean visit;
        Node (int n) {
            this.n = n;
            edge = new ArrayList<>();
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    nodes[i].edge.add(nodes[j]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!nodes[i].visit) {
                Queue<Node> queue = new LinkedList<>();
                queue.add(nodes[i]);
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (Node computer : node.edge) {
                        if (!computer.visit) {
                            queue.add(computer);
                            computer.visit = true;
                        }
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}