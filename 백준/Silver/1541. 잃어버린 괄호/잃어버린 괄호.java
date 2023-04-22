import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq = sc.nextLine();
        char[] chars = seq.toCharArray();
        int sum = 0;
        int temp = 0;
        boolean isMinus = false;
        for(char ch : chars) {
            if(ch != '+' && ch!= '-') {
                temp = temp * 10 + ch -'0';
            } else if(ch == '+') {
                if(isMinus) {
                    sum += temp * (-1);
                } else {
                    sum += temp;
                }
                temp = 0;
            } else { // '-'
                if(isMinus) {
                    sum += temp * (-1);
                } else {
                    sum += temp;
                }
                temp =0;
                isMinus = true;
            }
        }
        if(temp != 0) {
            if(isMinus) {
                sum += temp * (-1);
            } else {
                sum += temp;
            }
            temp = 0;
        }
        System.out.println(sum);
    }
}
