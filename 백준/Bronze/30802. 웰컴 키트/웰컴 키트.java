import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        String[] bundle = br.readLine().split(" ");
        int t = Integer.parseInt(bundle[0]);
        int p = Integer.parseInt(bundle[1]);

        int tSum = 0;
        for (int i = 0; i < input.length; i++) {
            double val = Double.parseDouble(input[i]);
            tSum += Math.ceil(val / t);  
        }
             
        bw.write(tSum + "\n");
        bw.write((size / p) + " " + (size % p) + "\n");
        bw.flush();
    }

}
