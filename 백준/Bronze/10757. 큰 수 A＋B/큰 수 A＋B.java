import java.io.*;
import java.math.BigInteger;
import java.util.*;

import javax.naming.Binding;

import java.awt.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);

		bw.write(a.add(b) + "\n");
		bw.flush();
	}
}