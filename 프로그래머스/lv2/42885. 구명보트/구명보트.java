
import java.util.Arrays;

// 7:45
class Solution {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int sum = 0;
        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            int temp = limit;
            temp -= people[r];
            sum++;
            if (r == l) {
                return sum;
            }

            if (people[l] <= temp) {
                temp -= people[l];
                l++;

            }

            if (l >= r) {
                break;
            }

            r--;
        }
        return sum;
    }

}
