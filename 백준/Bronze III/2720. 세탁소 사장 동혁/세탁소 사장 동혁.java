import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int C = sc.nextInt();
            int quarter = C / 25;
            C %= 25;
            int dime = C / 10;
            C %= 10;
            int nickel = C / 5;
            C %= 5;
            int penny = C;
            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
    }
}
