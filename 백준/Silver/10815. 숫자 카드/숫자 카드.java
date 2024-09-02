import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            map.put(sc.nextInt(), 0);
        }

        int m = sc.nextInt();
        for(int i = 0; i < m ; i++){
            if (map.containsKey(sc.nextInt())) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}

