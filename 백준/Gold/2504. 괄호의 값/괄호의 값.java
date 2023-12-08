
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long sum = 0;
        int small = 0;
        int big = 0;
        boolean isAlreadyCalculated = false;
        Deque<Character> dq = new ArrayDeque<>();
        for (char ch : line.toCharArray()) {
            if (ch == '(') {
                dq.addLast('(');
                small++;
                isAlreadyCalculated = false;
            } else if (ch == '[') {
                dq.addLast('[');
                big++;
                isAlreadyCalculated = false;
            } else if (ch == ')') {
                if(dq.isEmpty() || dq.pollLast() != '(') {
                    System.out.println(0);
                    return;
                }
                if (isAlreadyCalculated)  {
                    small--;
                    continue;
                }
                sum += (long) Math.pow(2, small) * (long) Math.pow(3, big);
                small--;
                isAlreadyCalculated = true;
            } else if (ch == ']') {
                if(dq.isEmpty() || dq.pollLast() != '[') {
                    System.out.println(0);
                    return;
                }
                if (isAlreadyCalculated)  {
                    big--;
                    continue;
                }
                sum += (long) Math.pow(2, small) * (long) Math.pow(3, big);
                big--;
                isAlreadyCalculated = true;
            }
        }
        if(!dq.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(sum);
    }
}
