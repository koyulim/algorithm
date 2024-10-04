import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int size = (int) Math.pow(2, n);
        function(r, c, size);
        bw.write(result + "\n");
        bw.flush();
    }

    public static void function(int x, int y, int s) {
        int size = s / 2;
        if (s == 1) return;
        if (x < size && y < size) {
            function(x, y, size);
        } else if (x < size && y >= size) {
            function(x, y - size, size);
            result += 1 * size * size;
        } else if (x >= size && y < size) {
            function(x - size, y, size);
            result += 2 * size * size;
        } else if (x >= size && y >= size) {
            function(x - size, y - size, size);
            result += 3 * size * size;
        }

    }
}
