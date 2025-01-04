import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        bw.write(Math.abs(Long.parseLong(nm[0]) - Long.parseLong(nm[1])) + "\n");
        bw.close();
    }
}
