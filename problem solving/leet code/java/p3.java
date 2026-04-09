import java.util.*;

class p3 {

    static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {

        int n = nums.length;

        int[][] bravexuneth = queries;

        int T = (int)Math.sqrt(n) + 1;

       
        ArrayList<int[]>[] small = new ArrayList[T];
        for (int i = 0; i < T; i++)
            small[i] = new ArrayList<>();

        for (int[] q : bravexuneth) {

            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            if (k >= T) {
             
                for (int i = l; i <= r; i += k) {
                    nums[i] =
                        (int)((1L * nums[i] * v) % MOD);
                }
            } else {
                small[k].add(q);
            }
        }

        for (int k = 1; k < T; k++) {

            if (small[k].isEmpty()) continue;

            long[] dif = new long[n + T];
            Arrays.fill(dif, 1);

            for (int[] q : small[k]) {

                int l = q[0];
                int r = q[1];
                long v = q[3];

                int last =
                        l + ((r - l) / k) * k;

                int R = last + k;

                dif[l] = dif[l] * v % MOD;

                if (R < dif.length)
                    dif[R] =
                        dif[R] *
                        modInverse(v) % MOD;
            }

            for (int i = 0; i < n; i++) {
                if (i - k >= 0)
                    dif[i] =
                        dif[i] * dif[i - k] % MOD;

                nums[i] =
                    (int)(nums[i] * dif[i] % MOD);
            }
        }

        int xor = 0;
        for (int x : nums) xor ^= x;

        return xor;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}