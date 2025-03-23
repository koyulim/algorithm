import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String str = "";
		for (int i = 1; i <= n / 4; i++) {
			str += "long ";
		}

		bw.write(str + "int" + "\n");
		bw.flush();
	}
}