import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean[] primeTable;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        primeTable = new boolean[end + 1];
        Arrays.fill(primeTable, true);
        makePrimeTable(end);
        for(int i = start; i <= end; i++) {
            if(primeTable[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void makePrimeTable(int end){
        primeTable[1] = false;
        for(int i = 2; i <=end;i++) {
            if(primeTable[i]) {
                if(isPrime(i)) {
                    for(int j = 2; j * i<= end; j++) {
                        primeTable[j*i] = false;
                    }
                } else {
                    for(int j = 1; j * i<= end; j++) {
                        primeTable[j*i] = false;
                    }
                }
            }
        }
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i * i<= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
