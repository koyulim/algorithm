import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        List<String> arr = new ArrayList<>();

        String val = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                arr.add(val);
                arr.add(String.valueOf(str.charAt(i)));
                val = "";
            } else {
                val += str.charAt(i);
            }
        }
        arr.add(val);

        int result = Integer.parseInt(arr.get(0));
        boolean chack = false;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).equals("-")) {
                chack = true;
            }
            if (!arr.get(i).equals("+") && !arr.get(i).equals("-")) {
                if (chack) {
                    result -= Integer.parseInt(arr.get(i));
                } else {
                    result += Integer.parseInt(arr.get(i));
                }
            }
        }
        
        bw.write(result + "\n");
        bw.flush();
    }
}
