package 算法题;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * 「回文串」是正读和反读都相同的字符串。
 * 示例 1：
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 示例 4：
 * 输入：s = "g"
 * 输出：0
 * 示例 5：
 * 输入：s = "no"
 * 输出：1
 * 提示：
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 */
public class likou1312 {
    public static void main(String[] args) {
        likou1312 likou = new likou1312();
        System.out.println(likou.minInsertions("leetcode"));
    }

    /**
     * 定义一个二维的 dp 数组，dp[i][j] 的定义如下：
     * 对字符串 s[i..j]，最少需要进行 dp[i][j] 次插入才能变成回文串。
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        if (s.length() == 1) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j - 1]) + 1,
                                          dp[i+1][j-1]+2);
            }
        }
        return dp[0][n-1];
    }

    /**
     * 状态压缩
     * @param s
     * @return
     */
    public int minInsertions2(String s) {
        if (s.length() == 1) return 0;
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int pre=0;
            for (int j = i + 1; j < n; j++) {
                int temp=dp[j];
                if (s.charAt(i) == s.charAt(j))
                    dp[j] = pre;
                else
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                pre=temp;
            }
        }
        return dp[n-1];
    }
}
