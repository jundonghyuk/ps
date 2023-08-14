
// 6:49 7:03
class Solution {
    static boolean[] isPrime = new boolean[101];
    static int[] nums = new int[101];

    public static int solution(int[] arr) {
        makePrimeTable();
        for (int i = 2; i <= 100; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j];
                int count = 0;
                while (num % i == 0) {
                    num = num/i;
                    count++;
                }
                nums[i] = Math.max(nums[i], count);
            }
        }
        int ret = 1;
        for(int i = 2; i <= 100;i++) {
            if(!isPrime[i]) {
                continue;
            }
            ret *= (int)(Math.pow(i, nums[i]));
        }
        return ret;
    }

    static void makePrimeTable() {
        isPrime[2] = true;
        isPrime[3] = true;
        for (int i = 2; i <= 100; i++) {
            boolean prime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                isPrime[i] = true;
            }
        }
    }
}
