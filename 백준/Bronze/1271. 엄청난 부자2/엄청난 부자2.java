import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        BigInteger n = new BigInteger(input[0]);
        BigInteger m = new BigInteger(input[1]);

        BigInteger share = n.divide(m);
        BigInteger remainder = n.remainder(m);
        bw.write(share + "\n");
        bw.write(remainder + "\n");
        bw.flush();
    }
}
