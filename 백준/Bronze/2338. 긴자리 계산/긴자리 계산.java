import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        bw.write(A.add(B).toString() + "\n");
        bw.write(A.subtract(B).toString() + "\n");
        bw.write(A.multiply(B).toString() + "\n");
        bw.flush();
    }
}
