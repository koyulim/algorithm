import java.awt.Point;
import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {

    private static class Tree{
        int root;
        Tree left;
        Tree right;
        Tree(int root) {
            this.root = root;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree root = new Tree(Integer.parseInt(br.readLine()));

        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }

            int value = Integer.parseInt(input);
            Tree parent = root;
            while (true) {
                if (value < parent.root) {
                    if (parent.left == null)  {
                        parent.left = new Tree(value);
                        break;
                    }
                    parent = parent.left;
                } else {
                    if (parent.right == null) {
                        parent.right = new Tree(value);
                        break;
                    }
                    parent = parent.right;
                }
            }
        }

        postOrder(root);
    }

    private static void postOrder(Tree root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.root);
    }
}
