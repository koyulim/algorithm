import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        
        HashMap<Character, Integer> map =  new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int value = (int)str.charAt(i);
            if (97 <= value && value <= 122) {
                map.put((char)(value - 32), map.getOrDefault((char)(value - 32), 0) + 1);
            } else {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }
        }

        int max = 0;
        char result = 0;
        for (char key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                result = key;
            }
        }

        int cnt = 0;
        for (char key : map.keySet()) {
            if (max == map.get(key)) {
                cnt++;
            }
        }

        if (cnt > 1) {
            bw.write("?" + "\n");
        } else {
            bw.write(result + "\n");
        }

        bw.close();
    }
}
