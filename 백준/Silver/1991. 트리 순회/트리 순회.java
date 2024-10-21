import java.util.*;
import java.io.*;

public class Main {

    static String pre = "";
    static String in = "";
    static String post = "";

    static class Node {
        char val;
        Node left;
        Node right;

        Node (char val) {
            this.val = val;
        }
    }

    public static Node createTree(Map<Character, Node> map, char parent, char left, char right) {
        Node parentNode = map.getOrDefault(parent, new Node(parent));
        if (left != '.') {
            parentNode.left = map.getOrDefault(left, new Node(left));
            map.put(left, parentNode.left);
        }
        if (right != '.') {
            parentNode.right = map.getOrDefault(right, new Node(right));
            map.put(right, parentNode.right);
        }
        map.put(parent, parentNode);
        return parentNode;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        
        Map<Character, Node> map = new HashMap<>();
        Node root = null;

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            if (root == null) {
                root = createTree(map, parent, left, right);
            } else {
                createTree(map, parent, left, right);
            }
        }

        preOrder(root);
        inOrder(root);
        postOrder(root);

        bw.write(pre + "\n");
        bw.write(in + "\n");
        bw.write(post + "\n");

        bw.flush();
    }

    public static void preOrder (Node root) {
        if (root == null) return;
        pre += root.val;
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder (Node root) {
        if (root == null) return;
        inOrder(root.left);
        in += root.val;
        inOrder(root.right);
    }

    public static void postOrder (Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        post += root.val;
    }
}
