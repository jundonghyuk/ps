
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int len = line.length();
        for (int i = 0; i<=len; i++) {
            for (int j = i + 1; j <= len; j++) {
                set.add(line.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}
