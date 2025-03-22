import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		BigInteger moves = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
        bw.write(moves.toString() + "\n");

		if (n <= 20) {
			hanoi(1, 3, 2, n);
		}

		bw.flush();
		bw.close();
	}

	private static void hanoi(int start, int end, int mid, int num) throws Exception {
		if (num == 0) return;
		hanoi(start, mid, end, num - 1);
		bw.write(start + " " + end + "\n");
		hanoi(mid, end, start, num - 1);
	}
}