import java.util.*;

class Solution {
    
    private static class Node {
        int n;
        List<Node> win;
        List<Node> lose;
        Node (int n) {
            this.n = n;
            win = new ArrayList<>();
            lose = new ArrayList<>();
        }
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            nodes[a].win.add(nodes[b]);
            nodes[b].lose.add(nodes[a]);
        }
        
        for (int i = 1; i <= n; i++) {
            Queue<Node> winQue = new LinkedList<>();
            Queue<Node> loseQue = new LinkedList<>();

            boolean[] visit = new boolean[n + 1];
            winQue.add(nodes[i]);
            loseQue.add(nodes[i]);
            visit[i] = true;
            
            while (!winQue.isEmpty()) {
                Node node = winQue.poll();
                for (Node valeue : node.win) {
                    if (!visit[valeue.n]) {
                        winQue.add(valeue);
                        visit[valeue.n] = true;
                    }
                }
            }
            
            while (!loseQue.isEmpty()) {
                Node node = loseQue.poll();
                for (Node valeue : node.lose) {
                    if (!visit[valeue.n]) {
                        loseQue.add(valeue);
                        visit[valeue.n] = true;
                    }
                }
            }
            
            boolean chack = false;
            for (int j = 1; j <= n; j++) {
                if (!visit[j]) {
                    chack = true;
                }
            }
            
            if (!chack) {
                answer++;
            }
            
        }
        
        
        return answer;
    }
}