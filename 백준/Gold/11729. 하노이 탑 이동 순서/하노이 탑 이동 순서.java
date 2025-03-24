import java.io.*;
import java.util.*;

public class Main {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		bw.write(((int)Math.pow(2, n) - 1) + "\n");
		
		hanoi(1, 3, 2, n);
		bw.flush();
	}

	private static void hanoi(int start, int end, int mid, int num) throws Exception{
		if (num == 1) {
			bw.write(start + " " + end + "\n");
			return;
		}

		hanoi(start, mid, end, num - 1);
		bw.write(start + " " + end + "\n");
		hanoi(mid, end, start, num - 1);
	}
}