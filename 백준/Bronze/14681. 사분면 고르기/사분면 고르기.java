import java.awt.Point;
import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (x > 0 && y > 00) {
            bw.write("1" + "\n");
        } else if (x < 0 && y > 0) {
            bw.write("2" + "\n");
        } else if (x < 0 && y < 0) {
            bw.write("3" + "\n");
        } else {
            bw.write("4" + "\n");
        }
        
        bw.flush();
    }
}
